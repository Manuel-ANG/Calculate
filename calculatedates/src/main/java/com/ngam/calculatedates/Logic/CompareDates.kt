package com.ngam.calculatedates.Logic

import com.ngam.calculatedates.data.Result
import org.joda.time.DateTime
import org.joda.time.DateTimeComparator
import org.joda.time.MutableDateTime
import java.util.*

class CompareDates {
    companion object {
        fun compare(date: String, current: Date?): Result {
            val comparator = DateTimeComparator.getDateOnlyInstance()
            val actual = current ?: DateTime()
            val dates = ConvertDate.toDate(date, "dd/MM/yyyy")
            val result = comparator.compare(actual, dates)
            return when {
                result == 0 -> {
                    Result.EQUAL
                }
                result < 0 -> {
                    Result.MAYOR
                }
                result > 0 -> {
                    Result.MENOR
                }
                else -> Result.MENOR
            }
        }

        fun rangeDate(date: String, minDate: Date, maxDate: Date): Result {
            val value = ConvertDate.toDate(date, "dd/MM/yyyy")
            return if (value != null) {
                if (value in minDate..maxDate) {
                    Result.IN_RANGE
                } else {
                    Result.ERROR
                }
            } else {
                Result.ERROR
            }
        }

        fun dateInRange(date: String, minDate: Date, maxDate: Date): Result {
            val value = ConvertDate.toDate(date, "dd/MM/yyyy")
            return if (value != null) {
                if (value > maxDate) {
                    Result.MAYOR
                } else if (value < minDate) {
                    Result.MENOR
                } else if (value in minDate..maxDate) {
                    Result.IN_RANGE
                }else{
                    Result.ERROR
                }
            } else {
                Result.ERROR
            }
        }

        fun minusDate(date: String, years: Int? = null, months: Int? = null, days: Int? = null): Date {
            val value = ConvertDate.toDate(date, "dd/MM/yyyy")
            val time = MutableDateTime(value)
            years?.let { y ->
                time.addYears(-y)
            }
            months?.let { m ->
                time.addMonths(-m)
            }
            days?.let { d ->
                time.addDays(-d)
            }
            return time.toDate()
        }

        fun plusDate(date: String, years: Int? = null, months: Int? = null, days: Int? = null): Date {
            val value = ConvertDate.toDate(date, "dd/MM/yyyy")
            val time = MutableDateTime(value)
            years?.let { y ->
                time.addYears(y)
            }
            months?.let { m ->
                time.addMonths(m)
            }
            days?.let { d ->
                time.addDays(d)
            }
            return time.toDate()
        }
    }
}