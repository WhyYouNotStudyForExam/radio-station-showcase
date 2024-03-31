package com.example.radiostationshowcase.domain.model

data class Playable(
    val city: String,
    val country: String,
    val genres: List<String>?,
    val id: String,
    val lastModified: Long,
    val logo100x100: String,
    val logo300x300: String,
    val logo630x630: String?,
    val name: String,
    val topics: List<String>,
    val streams: List<Stream>,
    val hasValidStreams: Boolean,
    val adParams: String,
    val type: String,
    val seoRelevantIn: List<String>,
    val blockingInformation: BlockingInformation
)
