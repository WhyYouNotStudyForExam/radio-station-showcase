package com.example.radiostationshowcase.domain.repository

import com.example.radiostationshowcase.domain.model.Playable
import com.example.radiostationshowcase.domain.model.RadioStation

interface RadioStationRepository {
    suspend fun getStations(): RadioStation

    suspend fun getStationById(id: String): List<Playable>
}