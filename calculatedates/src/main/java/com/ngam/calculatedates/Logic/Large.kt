package com.ngam.calculatedates.Logic

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.Years
class Large {
    companion object {
        fun calculateDays(start: DateTime, now: DateTime?): Int? {
            try {
                var current: DateTime? = null
                current = if (now != null) {
                    DateTime(now)
                } else {
                    DateTime()
                }

                return Days.daysBetween(start, current).days
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun calculateMonths(start: DateTime, now: DateTime?): Int? {
            try {
                var current: DateTime? = null
                if (now != null) {
                    current = now
                } else {
                    current = DateTime()
                }
                return Months.monthsBetween(start, current).months
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun calculateYears(start: DateTime, now: DateTime?): Int? {
            try {
                var current: DateTime? = null
                current = if (now != null) {
                    DateTime(now)
                } else {
                    DateTime()
                }
                return Years.yearsBetween(start, current).years
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

    }
}