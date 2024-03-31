package com.example.radiostationshowcase.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiostationshowcase.domain.model.RadioStation
import com.example.radiostationshowcase.domain.repository.RadioStationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopStationsViewModel @Inject constructor(
    private val radioStationRepository: RadioStationRepository
) : ViewModel() {
    val radioStations = MutableLiveData<List<RadioStation>>()
    init {
        getRadioStations()
    }
    fun getRadioStations() = viewModelScope.launch {
        val response = radioStationRepository.getStations().collect{ stations ->
            radioStations.postValue(stations)
        }
    }
}