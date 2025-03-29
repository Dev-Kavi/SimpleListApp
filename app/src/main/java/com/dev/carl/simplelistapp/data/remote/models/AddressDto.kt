package com.dev.carl.simplelistapp.data.remote.models

import com.squareup.moshi.Json

data class AddressDto(
    @field:Json(name = "city")
    val city: String,
    @field:Json(name = "geo")
    val geo: GeoDto,
    @field:Json(name = "street")
    val street: String,
    @field:Json(name = "suite")
    val suite: String,
    @field:Json(name = "zipcode")
    val zipcode: String
)