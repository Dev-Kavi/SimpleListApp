package com.dev.carl.simplelistapp.data.remote.repository

import com.dev.carl.simplelistapp.data.remote.api.UserApi
import com.dev.carl.simplelistapp.data.remote.models.UserResponse
import com.dev.carl.simplelistapp.domain.repository.UserRepository
import com.dev.carl.simplelistapp.domain.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepositoryImp @Inject constructor(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUserList(): Resource<UserResponse> {
        val response = try {
            api.getUserList()
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "An Unknown error occured")
        }
        return Resource.Success(response)
    }
}