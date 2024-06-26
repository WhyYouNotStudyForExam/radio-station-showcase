package com.example.radiostationshowcase.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radiostationshowcase.R
import com.example.radiostationshowcase.adapter.RadioStationsAdapter
import com.example.radiostationshowcase.ui.view_models.TopStationsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopStationsFragment : Fragment(R.layout.fragment_top_stations) {
    private val viewModel: TopStationsViewModel by viewModels()

    private lateinit var radioStationsAdapter: RadioStationsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
        observeRadioStation()

        radioStationsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putString("stationId", it.id)
            }
            findNavController().navigate(
                R.id.action_topStationsFragment_to_stationDetailsFragment,
                bundle
            )
        }
    }

    private fun setupRecyclerView(view: View) {
        radioStationsAdapter = RadioStationsAdapter(emptyList())
        val recyclerView: RecyclerView = view.findViewById(R.id.rvRadioStations)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = radioStationsAdapter
    }

    private fun observeRadioStation() {
        viewModel.radioStations.observe(viewLifecycleOwner) { station ->
            view?.findViewById<TextView>(R.id.tvTitle)?.text = station.title
            radioStationsAdapter.updateItems(station.playables)
        }
    }
}