package com.example.historyeveryday

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        // 通知の送信ロジックをここに追加

        return Result.success()
    }
}
