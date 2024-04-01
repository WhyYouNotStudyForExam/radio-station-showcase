package com.example.radiostationshowcase.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.radiostationshowcase.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StationDetailsFragment : Fragment(R.layout.fragment_station_details) {
    private val viewModel: StationDetailsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stationId = arguments?.getString("stationId")
        viewModel.setStationId(stationId)
        observePlayable()
    }

    private fun observePlayable() {
        viewModel.playable.observe(viewLifecycleOwner) { playable ->
            val playableItem = playable[0]
            val logoImageView: ImageView? = view?.findViewById(R.id.logoImageView)

            view?.let {
                if (logoImageView != null) {
                    Glide.with(it.context)
                        .load(playableItem.logo300x300)
                        .into(logoImageView)
                }
            }
            view?.findViewById<TextView>(R.id.stationName)?.text = playableItem.name
            view?.findViewById<TextView>(R.id.genres)?.text = context?.getString(R.string.genres_format, playableItem.genres?.joinToString(", "))
            view?.findViewById<TextView>(R.id.topics)?.text = context?.getString(R.string.topics_format, playableItem.topics?.joinToString(", "))
            view?.findViewById<TextView>(R.id.cityCountry)?.text = context?.getString(R.string.city_country_name, playableItem.city, playableItem.country)
            view?.findViewById<TextView>(R.id.description)?.text = playableItem.description
            view?.findViewById<TextView>(R.id.homepageUrl)?.text = playableItem.homepageUrl
        }
    }
}