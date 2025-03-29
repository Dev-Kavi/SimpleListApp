package com.dev.carl.simplelistapp.domain.repository

import com.dev.carl.simplelistapp.data.remote.models.UserResponse
import com.dev.carl.simplelistapp.domain.utils.Resource

interface UserRepository {
    suspend fun getUserList() : Resource<UserResponse>
}