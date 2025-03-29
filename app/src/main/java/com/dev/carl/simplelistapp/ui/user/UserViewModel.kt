package com.dev.carl.simplelistapp.ui.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.carl.simplelistapp.domain.repository.UserRepository
import com.dev.carl.simplelistapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var state by mutableStateOf(UserState())
        private set

    init {
        loadUserData()
    }

    private fun loadUserData() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (val result = repository.getUserList()) {
                is Resource.Error -> {
                    state = state.copy(
                        userData = null,
                        isLoading = false,
                        error = result.message
                    )
                }

                is Resource.Success -> {
                    state = state.copy(
                        userData = result.data,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }
}