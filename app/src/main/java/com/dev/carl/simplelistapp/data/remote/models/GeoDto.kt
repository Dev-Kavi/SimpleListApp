package com.dev.carl.simplelistapp.data.remote.models

import com.squareup.moshi.Json

data class GeoDto(
    @field:Json(name = "lat")
    val lat: String,
    @field:Json(name = "lng")
    val lng: String
)