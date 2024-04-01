package com.example.radiostationshowcase.domain.repository

import com.example.radiostationshowcase.domain.model.Playable
import com.example.radiostationshowcase.domain.model.RadioStation
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val DEFAULT_COUNT: Int = 100
        const val DEFAULT_SYSTEM_NAME: String = "STATIONS_TOP"
    }

    @GET("stations/list-by-system-name?systemName=${DEFAULT_SYSTEM_NAME}&count=${DEFAULT_COUNT}")
    suspend fun getRadioStations(): RadioStation

    @GET("stations/details")
    suspend fun getRadioStationDetails(@Query("stationIds") stationId: String): List<Playable>
}