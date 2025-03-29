package com.dev.carl.simplelistapp.data.remote.api

import com.dev.carl.simplelistapp.data.remote.models.UserResponse
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUserList() : UserResponse
}