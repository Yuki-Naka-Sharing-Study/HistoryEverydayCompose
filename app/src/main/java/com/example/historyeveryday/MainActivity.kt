package com.example.historyeveryday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scheduleDailyNotification()

        setContent {
            HistoryScreen(context = this)
        }
    }

    private fun scheduleDailyNotification() {
        val notificationWork = OneTimeWorkRequest.Builder(NotificationWorker::class.java)
            .setInitialDelay(24, TimeUnit.HOURS) // 24時間後に通知
            .setInputData(workDataOf("message" to "今日は五 一五事件の日"))
            .build()

        WorkManager.getInstance(this).enqueue(notificationWork)
    }
}