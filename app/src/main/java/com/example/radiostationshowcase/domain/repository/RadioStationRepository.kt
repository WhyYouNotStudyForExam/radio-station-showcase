package com.example.radiostationshowcase.domain.repository

import com.example.radiostationshowcase.domain.model.RadioStation
import kotlinx.coroutines.flow.Flow

interface RadioStationRepository {
    suspend fun getStations(): RadioStation

    fun getStationById(id: Int): RadioStation
}