package com.dev.carl.simplelistapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CompanyData(
    val bs: String,
    val catchPhrase: String,
    val name: String
)