package com.example.radiostationshowcase.domain.model

data class BlockingInformation(
    val isBlocked: Boolean,
    val isBlockedIn: List<Any>
)
