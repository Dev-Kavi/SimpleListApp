package com.dev.carl.simplelistapp.domain.models

data class UserDataItem(
    val address: AddressData,
    val company: CompanyData,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)