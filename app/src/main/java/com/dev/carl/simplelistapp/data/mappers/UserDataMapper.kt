package com.dev.carl.simplelistapp.data.mappers

import com.dev.carl.simplelistapp.data.remote.models.AddressDto
import com.dev.carl.simplelistapp.data.remote.models.CompanyDto
import com.dev.carl.simplelistapp.data.remote.models.GeoDto
import com.dev.carl.simplelistapp.data.remote.models.UserResponseItemDto
import com.dev.carl.simplelistapp.domain.models.AddressData
import com.dev.carl.simplelistapp.domain.models.CompanyData
import com.dev.carl.simplelistapp.domain.models.GeoData
import com.dev.carl.simplelistapp.domain.models.UserDataItem

fun UserResponseItemDto.toUserDataItem(): UserDataItem {
    return UserDataItem(
        address = this.address.toAddressData(),
        company = this.company.toCompanyData(),
        email = this.email,
        id = this.id,
        name = this.name,
        phone = this.phone,
        username = this.username,
        website = this.website
    )
}

fun AddressDto.toAddressData(): AddressData {
    return AddressData(
        city = this.city,
        geo = this.geo.toGeoData(),
        street = this.street,
        suite = this.suite,
        zipcode = this.zipcode
    )
}

fun CompanyDto.toCompanyData(): CompanyData {
    return CompanyData(
        bs = this.bs,
        catchPhrase = this.catchPhrase,
        name = this.name
    )
}

fun GeoDto.toGeoData(): GeoData {
    return GeoData(
        lat = this.lat,
        lng = this.lng
    )
}