package com.dev.carl.simplelistapp.data.remote.models

import com.squareup.moshi.Json

data class CompanyDto(
    @field:Json(name = "bs")
    val bs: String,
    @field:Json(name = "catchPhrase")
    val catchPhrase: String,
    @field:Json(name = "name")
    val name: String
)