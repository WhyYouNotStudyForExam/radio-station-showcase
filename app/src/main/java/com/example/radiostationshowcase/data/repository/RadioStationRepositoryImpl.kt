package com.example.radiostationshowcase.data.repository

import com.example.radiostationshowcase.domain.model.RadioStation
import com.example.radiostationshowcase.domain.repository.RadioStationRepository
import kotlinx.coroutines.flow.Flow

class RadioStationRepositoryImpl(): RadioStationRepository {
    override fun getStations(): Flow<List<RadioStation>> {
        TODO("Not yet implemented")
    }

    override fun getStationById(id: Int): RadioStation {
        TODO("Not yet implemented")
    }
}