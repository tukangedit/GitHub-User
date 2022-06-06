package com.bangkit.githubuser.api

import com.bangkit.githubuser.models.DetailUserResponse
import com.bangkit.githubuser.models.User
import com.bangkit.githubuser.models.UserResponse
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