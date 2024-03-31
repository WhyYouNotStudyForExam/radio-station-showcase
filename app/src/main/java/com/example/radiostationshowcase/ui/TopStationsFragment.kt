package com.example.radiostationshowcase.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.radiostationshowcase.R
import com.example.radiostationshowcase.adapter.RadioStationsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopStationsFragment : Fragment(R.layout.fragment_top_stations) {
    private val viewModel: TopStationsViewModel by viewModels()

    private lateinit var radioStationsAdapter: RadioStationsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
        observeRadioStations()
    }

    private fun setupRecyclerView(view: View) {
        radioStationsAdapter = RadioStationsAdapter(emptyList())
        val recyclerView: RecyclerView = view.findViewById(R.id.rvRadioStations)
        recyclerView.adapter = radioStationsAdapter
    }

    private fun observeRadioStations() {
        viewModel.radioStations.observe(viewLifecycleOwner) { stations ->
            radioStationsAdapter.updateItems(stations)
        }
    }
}