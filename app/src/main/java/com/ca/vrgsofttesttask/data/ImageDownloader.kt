package com.ca.vrgsofttesttask.data

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class ImageDownloader(context: Context) {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    fun downloadImage(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/jpeg")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle(url.split("/").last())
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, url.split("/").last())
        return downloadManager.enqueue(request)
    }
}