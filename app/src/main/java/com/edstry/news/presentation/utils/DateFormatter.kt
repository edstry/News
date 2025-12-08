package com.edstry.news.presentation.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.logging.SimpleFormatter

private val formatter = SimpleDateFormat.getDateInstance(DateFormat.SHORT)

fun Long.formatDate(): String {
    return formatter.format(this)
}