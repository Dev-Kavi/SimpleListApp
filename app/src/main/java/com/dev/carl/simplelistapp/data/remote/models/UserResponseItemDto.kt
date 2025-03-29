package com.dev.carl.simplelistapp.data.remote.models

import com.squareup.moshi.Json

data class UserResponseItemDto(
    @field:Json(name = "address")
    val address: AddressDto,
    @field:Json(name = "company")
    val company: CompanyDto,
    @field:Json(name = "email")
    val email: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "phone")
    val phone: String,
    @field:Json(name = "username")
    val username: String,
    @field:Json(name = "website")
    val website: String
)