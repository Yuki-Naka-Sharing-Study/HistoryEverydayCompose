package com.example.historyeveryday

import com.google.gson.annotations.SerializedName

data class HistoryEvent(
    val date: String,
    val event: String,
    val description: String,
    @SerializedName ("image_url") val imageUrl: String
)
