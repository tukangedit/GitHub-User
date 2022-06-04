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