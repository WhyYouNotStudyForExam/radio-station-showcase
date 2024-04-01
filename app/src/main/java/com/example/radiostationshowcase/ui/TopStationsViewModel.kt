package com.example.radiostationshowcase.ui

import androidx.lifecycle.LiveData
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
    private val _radioStations = MutableLiveData<RadioStation>()
    val radioStations: LiveData<RadioStation> = _radioStations
    init {
        getRadioStations()
    }
    private fun getRadioStations() = viewModelScope.launch {
        _radioStations.value = radioStationRepository.getStations()
    }
}