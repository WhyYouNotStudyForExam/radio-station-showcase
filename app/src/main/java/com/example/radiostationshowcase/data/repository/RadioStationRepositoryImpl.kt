package com.example.radiostationshowcase.data.repository

import com.example.radiostationshowcase.data.data_source.RetrofitClient.apiService
import com.example.radiostationshowcase.domain.model.Playable
import com.example.radiostationshowcase.domain.model.RadioStation
import com.example.radiostationshowcase.domain.repository.RadioStationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RadioStationRepositoryImpl() : RadioStationRepository {
    override suspend fun getStations(): RadioStation {
        return apiService.getRadioStations()
    }

    override suspend fun getStationById(id: String): List<Playable> {
        return apiService.getRadioStationDetails(id)
    }
}