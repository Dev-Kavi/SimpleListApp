package com.dev.carl.simplelistapp.domain.models

data class AddressData(
    val city: String,
    val geo: GeoData,
    val street: String,
    val suite: String,
    val zipcode: String
)