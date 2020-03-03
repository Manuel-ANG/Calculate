package com.ngam.calculatedates.Logic

import com.ngam.calculatedates.App.Companion.getContext
import com.ngam.calculatedates.R
import org.joda.time.*
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.ExperimentalTime

class CalculateDate {
    companion object {
        private fun applyformat(): DateTimeFormatter? {
            return DateTimeFormat.forPattern("dd/MM/yyyy").withLocale(Locale.getDefault())
        }

        fun calculateDays(start: String, now: Date?): Int? {
            try {
                val nacimiento = DateTime("${applyformat()?.parseDateTime(start.replace("-", "/"))}")
                var current: DateTime? = null
                current = if (now != null) {
                    DateTime(now)
                } else {
                    DateTime()
                }

                return Days.daysBetween(nacimiento, current).days
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }


        fun calculateCurrentDays(start: String): Int? {
            return calculateDays(start, null)
        }

        fun calculateMonths(start: String, now: Date?): Int? {
            try {
                val nacimiento = DateTime("${applyformat()?.parseDateTime(start.replace("-", "/"))}")
                var current: DateTime? = null
                current = if (now != null) {
                    DateTime(now)
                } else {
                    DateTime()
                }
                return Months.monthsBetween(nacimiento, current).months
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }


        fun calculateCurrentMonths(start: String): Int? {
            return calculateMonths(start, null)
        }

        fun calculateYears(start: String, now: Date?): Int? {
            try {
                val nacimiento = DateTime("${applyformat()?.parseDateTime(start.replace("-", "/"))}")
                var current: DateTime? = null
                current = if (now != null) {
                    DateTime(now)
                } else {
                    DateTime()
                }

                return Years.yearsBetween(nacimiento, current).years
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        fun calculateCurrentYears(start: String): Int? {
            return calculateYears(start, null)
        }

        fun calculateLargeDate(start: String, now: String?): String? {
            var addeddays = 0
            var dias = 0
            val meses: Int
            val anios: Int
            val builder = StringBuilder()
            var mDays: Int
            val tiempo1: DateTime?
            val tiempo2: DateTime?
            val current: DateTime? = if (now != null) {
                DateTime(now)
            } else {
                DateTime()
            }

            try {
                val nacimiento = DateTime("${applyformat()?.parseDateTime(start.replace("-", "/"))}");
                val mAno = Large.calculateYears(nacimiento, current)

                if (nacimiento.dayOfMonth > parseTime((nacimiento.year + mAno!!), nacimiento.monthOfYear).dayOfMonth) {
                    val diference = nacimiento.dayOfMonth - parseTime((nacimiento.year + mAno), nacimiento.monthOfYear).dayOfMonth
                    tiempo1 = DateTime((nacimiento.year + mAno), nacimiento.monthOfYear, (nacimiento.dayOfMonth - diference), 0, 0)
                } else {
                    tiempo1 = DateTime((nacimiento.year + mAno), nacimiento.monthOfYear, nacimiento.dayOfMonth, 0, 0)
                }

                val mMes = Large.calculateMonths(tiempo1, current)
                val mon = mMes!! + tiempo1.monthOfYear
                var tempYear = tiempo1.year
                val resta: Int?
                if (mon > 12) {
                    resta = mon - 12
                    tempYear++;
                } else {
                    resta = mon;
                }

                if (tiempo1.dayOfMonth > parseTime(tempYear, resta).dayOfMonth) {
                    addeddays = tiempo1.dayOfMonth - parseTime(tempYear, resta).dayOfMonth
                    tiempo2 = DateTime(tempYear, resta, (tiempo1.dayOfMonth - addeddays), 0, 0)
                } else {
                    tiempo2 = DateTime(tempYear, resta, tiempo1.dayOfMonth, 0, 0)
                }
                anios = mAno
                meses = mMes
                Large.calculateDays(tiempo2, current)?.let {
                    dias = it - addeddays
                }
                if (anios > 0) {
                    builder.append(anios).append(
                            if (anios == 1) " ${getContext()?.getString(R.string.year)}" else " ${getContext()?.getString(
                                    R.string.years
                            )}"
                    )
                    if (meses > 0) {
                        if (builder.length > 0) {
                            builder.append(" ")
                        }
                        builder.append(meses).append(
                                if (meses > 1) " ${getContext()?.getString(R.string.months)}" else " ${getContext()?.getString(
                                        R.string.month
                                )}"
                        )
                    }
                    if (dias > 0) {
                        if (builder.length > 0) {
                            builder.append(" ")
                        }
                        builder.append(dias).append(
                                if (dias == 1) " ${getContext()?.getString(R.string.day)}" else " ${getContext()?.getString(
                                        R.string.days
                                )}"
                        )
                    }
                } else {
                    if (meses > 0) {
                        if (builder.length > 0) {
                            builder.append(" ")
                        }
                        builder.append(meses).append(
                                if (meses > 1) " ${getContext()?.getString(R.string.months)}" else " ${getContext()?.getString(
                                        R.string.month
                                )}"
                        )
                        if (dias > 0) {
                            if (builder.length > 0) {
                                builder.append(" ")
                            }
                            builder.append(dias).append(
                                    if (dias == 1) " ${getContext()?.getString(R.string.day)}" else " ${getContext()?.getString(
                                            R.string.days
                                    )}"
                            )
                        }
                    } else {
                        if (builder.length > 0) {
                            builder.append(" ")
                        }
                        builder.append(dias).append(
                                if (dias == 1) " ${getContext()?.getString(R.string.day)}" else " ${getContext()?.getString(
                                        R.string.days
                                )}"
                        )
                    }
                }
                return builder.toString()
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }
        }

        private fun parseTime(year: Int, month: Int): DateTime {
            val day = Calendar.getInstance()
            day.set(Calendar.MONTH, (month - 1))
            val time = DateTime(year, month, day.getActualMaximum(Calendar.DATE), 0, 0)
            return time
        }
    }
}