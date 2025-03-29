package com.dev.carl.simplelistapp.ui.user

import com.dev.carl.simplelistapp.domain.models.UserData

data class UserState(
    val userData: UserData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)