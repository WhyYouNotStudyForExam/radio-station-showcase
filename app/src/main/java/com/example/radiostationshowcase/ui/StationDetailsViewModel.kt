package com.example.radiostationshowcase.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radiostationshowcase.domain.repository.RadioStationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StationDetailsViewModel @Inject constructor(
    private val radioStationRepository: RadioStationRepository
) : ViewModel() {

    private val _stationId = MutableLiveData<String?>()
    val stationId: LiveData<String?> = _stationId

    fun setStationId(stationId: String?) {
        _stationId.value = stationId
    }
}
