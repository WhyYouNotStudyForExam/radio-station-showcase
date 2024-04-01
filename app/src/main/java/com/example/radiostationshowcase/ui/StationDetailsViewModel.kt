package com.example.radiostationshowcase.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiostationshowcase.domain.model.Playable
import com.example.radiostationshowcase.domain.repository.RadioStationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationDetailsViewModel @Inject constructor(
    private val radioStationRepository: RadioStationRepository
) : ViewModel() {

    private val _stationId = MutableLiveData<String?>()
    val stationId: LiveData<String?> = _stationId
    private val _playable = MutableLiveData<List<Playable>>()
    val playable: LiveData<List<Playable>> = _playable

    private fun getRadioStationById() = viewModelScope.launch {
        if (stationId.value != null) {
            _playable.value = radioStationRepository.getStationById(stationId.value!!)
        }
    }

    fun setStationId(stationId: String?) {
        _stationId.value = stationId
        getRadioStationById()
    }
}
