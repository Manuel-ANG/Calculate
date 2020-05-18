package com.ngam.calculatedates.Logic

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.util.*

class ConvertDate {
    companion object {

        fun toDate(value: Long): Date? {
            return DateTime(value).toDate()
        }

        fun toLong(value: Date): Long? {
            return DateTime(value.time).toDate().time
        }

        fun toDate(value: String): Date? {
            var convertDate: String? = null
            try {
                if (value.contains("-")) {
                    convertDate = value.replace("-", "/")
                } else if (value.contains(".")) {
                    convertDate = value.replace(".", "/")
                }
                val date = DateTime("${applyformat()?.parseDateTime(convertDate)}")
                return date.toDate()
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun toDate(value: String, dateFormat: String): Date? {
            var convertDate: String? = null
            try {

                if (dateFormat.contains("-")) {
                    convertDate = value.replace("[-./]".toRegex(), "-")
                } else if (dateFormat.contains("/")) {
                    convertDate = value.replace("[-./]".toRegex(), "/")
                } else if (dateFormat.contains(".")) {
                    convertDate = value.replace("[-./]".toRegex(), ".")
                }
                val date = DateTime("${applyCustomFormat(dateFormat)?.parseDateTime(convertDate)}")
                return date.toDate()
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun toTimeStamp(value: String): String? {
            var convertDate: String? = null
            try {
                if (value.contains("-")) {
                    convertDate = value.replace("-", "/")
                } else if (value.contains(".")) {
                    convertDate = value.replace(".", "/")
                }
                val date = DateTime("${applyformat()?.parseDateTime(convertDate)}")
                return date.toString()
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun toTimeStamp(value: String, dateFormat: String): String? {
            var convertDate: String? = null
            try {
                if (dateFormat.contains("-")) {
                    convertDate = value.replace("[-./]".toRegex(), "-")
                } else if (dateFormat.contains("/")) {
                    convertDate = value.replace("[-./]".toRegex(), "/")
                } else if (dateFormat.contains(".")) {
                    convertDate = value.replace("[-./]".toRegex(), ".")
                }
                val date = DateTime("${applyCustomFormat(dateFormat)?.parseDateTime(convertDate)}")
                return date.toString()
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun convertDate(value: Date?, format: String): String? {
            var time: Date? = null
            return try {
                value?.let {
                    time = it
                } ?: run {
                    time = DateTime().toDate()
                }
                val formats = applyCustomFormat(format)
                formats?.print(DateTime(time))
            } catch (e: Throwable) {
                e.printStackTrace()
                null
            }
        }

        private fun applyformat(): DateTimeFormatter? {
            return DateTimeFormat.forPattern("dd/MM/yyyy").withLocale(Locale.getDefault())
        }

        private fun applyCustomFormat(format: String): DateTimeFormatter? {
            return DateTimeFormat.forPattern(format).withLocale(Locale.getDefault())
        }

        fun addDaysToDate(date: String?, format: String, days: Int): String? {
            var dates: DateTime? = null
            date?.let {
                dates = DateTime("${applyCustomFormat(format)?.parseDateTime(date)}")
            } ?: run {
                dates = DateTime()
            }
            val added = dates!!.plusDays(days)
            return convertDate(added.toDate(), format)
        }
    }
}