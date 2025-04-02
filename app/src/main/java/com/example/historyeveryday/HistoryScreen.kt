package com.example.historyeveryday

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = viewModel(), context: Context) {
    val events = viewModel.getEventsForToday(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "今日は何の日？",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        events.forEach { event ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                val imageUrl = event.imageUrl

                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(imageUrl)
//                        .size(Size.ORIGINAL)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(com.example.historyeveryday.R.drawable.ic_launcher_background),
                    error = painterResource(com.example.historyeveryday.R.drawable.error),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = event.event,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = event.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Log.d("HistoryScreen", "Image URL: ${event.imageUrl}")

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewHistoryScreen() {
    HistoryScreen(context = LocalContext.current)
}