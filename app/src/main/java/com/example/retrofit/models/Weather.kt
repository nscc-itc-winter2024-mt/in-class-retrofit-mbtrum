package com.example.retrofit.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val current: Current,
    val location: Location
)

data class Location(
    val name: String,
    val region: String,
    val country: String
)

data class Current (
    @SerializedName("temp_c") val temperature: Float,
    @SerializedName("wind_kph") val windSpeed: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("feelslike_c") val feelsLike: Float,
    val condition: Condition
)

data class Condition (
    val text: String,
    val icon: String
)

//data class Forecast ()