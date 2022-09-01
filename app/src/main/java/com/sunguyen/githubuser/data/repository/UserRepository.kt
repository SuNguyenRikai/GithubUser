package com.sunguyen.githubuser.data.repository

import com.sunguyen.githubuser.data.model.User
import com.sunguyen.githubuser.data.model.UserDetail
import com.sunguyen.githubuser.data.restapi.GitHubAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val gitHubAPI: GitHubAPI
) {
    //Get user list
    suspend fun getUsers(perPage: Int): List<User> {
        return gitHubAPI.getUsers(perPage = perPage)
    }

    //Get user detail
    suspend fun getUserDetail(userName : String): UserDetail {
        return gitHubAPI.getDetailUser(username = userName)
    }
}