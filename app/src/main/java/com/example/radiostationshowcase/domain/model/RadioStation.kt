package com.example.radiostationshowcase.domain.model

data class RadioStation(
    val systemName: String,
    val title: String,
    val playables: List<Playable>,
    val displayType: String,
    val count: Int,
    val offset: Int,
    val totalCount: Int
)
