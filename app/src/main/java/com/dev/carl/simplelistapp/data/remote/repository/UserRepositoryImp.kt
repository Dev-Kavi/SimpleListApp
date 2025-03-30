package com.dev.carl.simplelistapp.data.remote.repository


import com.dev.carl.simplelistapp.data.mappers.toUserDataItem
import com.dev.carl.simplelistapp.data.remote.api.UserApi
import com.dev.carl.simplelistapp.domain.models.UserData
import com.dev.carl.simplelistapp.domain.repository.UserRepository
import com.dev.carl.simplelistapp.domain.utils.Resource
import com.dev.carl.simplelistapp.domain.utils.UserDataStore
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val api: UserApi,
    private val userDataStore: UserDataStore
) : UserRepository {
    override suspend fun getUserList(): Resource<UserData> {
        return try {
            val response = api.getUserList()
            val userData = UserData(userData = response.map { it.toUserDataItem() })

            userDataStore.saveUserData(userData)

            Resource.Success(userData)
        } catch (e: Exception) {
            val cachedUserData = userDataStore.getUserData()
            if (cachedUserData != null) {
                Resource.Success(cachedUserData)
            } else {
                Resource.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}