package com.aold.core.utils.functional

/**
 * @author Kirilin Yury on 22.05.2023.
 */
enum class TimePeriod {
    WEEK, MONTH, YEAR;

    fun convertToDays() = when (this) {
        WEEK -> Constants.Date.DAYS_IN_WEEK
        MONTH -> Constants.Date.DAYS_IN_MONTH
        YEAR -> Constants.Date.DAYS_IN_YEAR
    }
}
