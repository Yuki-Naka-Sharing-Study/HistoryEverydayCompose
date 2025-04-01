package com.example.historyeveryday

import android.content.Context
import com.google.gson.Gson
import java.io.InputStreamReader

fun loadHistoryEvents(context: Context): List<HistoryEvent> {
    val inputStream = context.resources.openRawResource(R.raw.history_events)
    val reader = InputStreamReader(inputStream)
    return Gson().fromJson(reader, Array<HistoryEvent>::class.java).toList()
}
