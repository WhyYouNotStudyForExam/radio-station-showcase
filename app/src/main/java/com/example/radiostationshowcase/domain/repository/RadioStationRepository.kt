package com.example.radiostationshowcase.domain.repository

import com.example.radiostationshowcase.domain.model.RadioStation
import kotlinx.coroutines.flow.Flow

interface RadioStationRepository {
    fun getStations(): Flow<List<RadioStation>>

    fun getStationById(id: Int): RadioStation
}