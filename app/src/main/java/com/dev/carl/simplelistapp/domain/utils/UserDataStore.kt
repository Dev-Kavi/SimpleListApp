package com.dev.carl.simplelistapp.domain.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.dev.carl.simplelistapp.domain.models.UserData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UserDataStore @Inject constructor(@ApplicationContext private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "user_data")

    companion object {
        private const val KEY_USER_DATA = "key_user_data"
    }

    suspend fun saveUserData(userData: UserData) {
        context.dataStore.edit { preferences ->
            val userDataJson = Gson().toJson(userData)
            preferences[stringPreferencesKey(KEY_USER_DATA)] = userDataJson
        }
    }

    suspend fun getUserData(): UserData? {
        val preferences = context.dataStore.data.first()
        val userDataJson = preferences[stringPreferencesKey(KEY_USER_DATA)]
        return if (userDataJson != null) {
            Gson().fromJson(userDataJson, UserData::class.java)
        } else {
            null
        }
    }
}