package ua.vmartyniuk.top100albums.core.common

import java.text.SimpleDateFormat
import java.util.*

private val patterns = mapOf(
    "[a-zA-Z]{3},\\s\\d{2}\\s[a-zA-Z]{3}\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}\\s\\+*" to "EEE, dd MMM yyyy HH:mm:ss`Z`",
    "[a-zA-Z]{3},\\s\\d{2}\\s[a-zA-Z]{3}\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}" to "EEE, dd MMM yyyy HH:mm:ss",
    "\\d{4}-\\d{2}-\\d{2}" to "yyyy-MM-dd",
    "\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}" to "yyyy-MM-dd HH:mm:ss"
)

fun Date.ofPattern(pattern: String): String {
    val sdf = SimpleDateFormat(pattern, Locale.US)
    return sdf.format(this)
}

fun Date.format(): String {
    return this.ofPattern(patterns.values.first())
}

fun String.toDate(): Date? {
    val stringDate = this
    val key = patterns.keys.findLast { regexString ->
        regexString.toRegex().containsMatchIn(stringDate)
    }

    if (key.isNullOrEmpty()) {
        return null
    }

    val sdf = SimpleDateFormat(patterns[key]!!, Locale.ENGLISH)
    return try {
        sdf.parse(stringDate)
    } catch (ex: Exception) {
        null
    }
}