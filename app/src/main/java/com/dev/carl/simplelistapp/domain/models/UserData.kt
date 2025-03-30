package com.dev.carl.simplelistapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val userData : List<UserDataItem>
)