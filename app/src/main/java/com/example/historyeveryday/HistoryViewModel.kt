package com.example.historyeveryday

import android.content.Context
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class HistoryViewModel : ViewModel() {
    private val historyEvents = mutableListOf<HistoryEvent>()

    fun getEventsForToday(context: Context): List<HistoryEvent> {
        if (historyEvents.isEmpty()) {
            historyEvents.addAll(loadHistoryEvents(context))
        }
        val today = SimpleDateFormat("MM-dd", Locale.getDefault()).format(Date())
        return historyEvents.filter { it.date == today }.orEmpty()
    }
}