package com.example.radiostationshowcase.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.radiostationshowcase.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StationDetailsFragment : Fragment(R.layout.fragment_station_details) {
    private val viewModel: StationDetailsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stationId = arguments?.getString("stationId")
        viewModel.setStationId(stationId)
    }
}