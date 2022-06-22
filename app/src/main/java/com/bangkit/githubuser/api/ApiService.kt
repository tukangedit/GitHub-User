package com.bangkit.githubuser.api

import com.bangkit.githubuser.data.model.DetailUserResponse
import com.bangkit.githubuser.data.model.User
import com.bangkit.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(

        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
    
}