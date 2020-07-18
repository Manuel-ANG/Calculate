package com.ngam.calculatedates.Logic

import com.ngam.calculatedates.data.Result
import org.joda.time.DateTime
import org.joda.time.DateTimeComparator
import java.util.*

class CompareDates {
    companion object {
        fun compare(date: String, current: Date?): Result {
            val comparator = DateTimeComparator.getDateOnlyInstance()
            val actual = current ?: DateTime()
            val dates=ConvertDate.toDate(date,"dd/MM/yyyy")
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
    }
}