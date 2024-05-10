package com.ca.vrgsofttesttask.utils

fun getRelativeTime(utcSeconds: Long): String {
    return android.text.format.DateUtils.getRelativeTimeSpanString(utcSeconds * 1000).toString()
}