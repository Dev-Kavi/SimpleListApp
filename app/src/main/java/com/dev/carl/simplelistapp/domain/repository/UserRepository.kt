package com.dev.carl.simplelistapp.domain.repository

import com.dev.carl.simplelistapp.domain.models.UserData
import com.dev.carl.simplelistapp.domain.utils.Resource

interface UserRepository {
    suspend fun getUserList(): Resource<UserData>
}