package com.dev.carl.simplelistapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class AddressData(
    val city: String,
    val geo: GeoData,
    val street: String,
    val suite: String,
    val zipcode: String
)