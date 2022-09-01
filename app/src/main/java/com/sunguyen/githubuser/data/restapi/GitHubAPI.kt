package com.sunguyen.githubuser.data.restapi

import com.sunguyen.githubuser.data.model.User
import com.sunguyen.githubuser.data.model.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface GitHubAPI {
    //Get user list
    @GET("users")
    suspend fun getUsers(@Query("per_page") perPage : Int) : List<User>

    //get user detail
    @GET("users/{username}")
    suspend fun getDetailUser(@Path("username") username: String) : UserDetail
}