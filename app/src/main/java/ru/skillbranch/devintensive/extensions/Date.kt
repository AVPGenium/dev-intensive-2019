package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L // 1s = 1000ms
const val MINUTE = 60 * SECOND // 1m = 60s
const val HOUR = 60 * MINUTE // 1h = 60m
const val DAY = 24 * HOUR // 1d = 24h
const val DATE_FORMAT = "HH:mm:ss dd.MM.yy"

/**
 * Единицы измерения времени
 */
enum class TimeUnits {
    SECOND, MINUTE, HOUR, DAY
}

/**
 * Расширение, позволяющее форматировать дату по маске (по умолчанию "HH:mm:ss dd.MM.yy")
 * @return отформатированная дата по паттерну передаваемому в качестве аргумента (значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
 */
fun Date.format(pattern: String = DATE_FORMAT): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

/**
 * Расширение, позволяющее измененять значения экземпляра Data (добавление/вычитание) на указанную временную единицу
 */
fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    this.time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    return this
}