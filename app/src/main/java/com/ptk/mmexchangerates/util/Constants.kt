package com.ptk.mmexchangerates.util

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


const val BASE_URL = "http://forex.cbm.gov.mm/"

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String {
    val now = Calendar.getInstance()
    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(now.time).toString()
}

fun getCurrentTime(): String {
    val now = Calendar.getInstance()
    val dateFormat: DateFormat = SimpleDateFormat("HH:mm:ss")
    return dateFormat.format(now.time).toString()
}

