package com.dev.carl.simplelistapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class GeoData(
    val lat: String,
    val lng: String
)