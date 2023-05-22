package com.aold.core.utils.functional

/**
 * @author Kirilin Yury on 22.05.2023.
 */
object Constants {

    object Text {
        const val MAX_LENTGHTH = 50
    }

    object Notification {
        const val CHANNEL_ID = "timeTaskAlarmChannel"
    }

    object Alarm {
        const val ALARM_NOTIFICATION_ACTION = "com.aold.ALARM_NOTIFICATION_ACTION"
        const val NOTIFICATION_CATEGORY = "ALARM_DATA_CATEGORY"
        const val NOTIFICATION_SUBCATEGORY = "ALARM_DATA_SUBCATEGORY"
        const val NOTIFICATION_ICON = "ALARM_DATA_ICON"
        const val APP_ICON = "ALARM_DATA_APP_ICON"
    }

    object Placeholder {
        const val items = 6
    }

    object Delay {
        const val LOAD_ANIMATION = 400L
        const val SPLASH = 600L
        const val CHECK_STATUS = 5000L
    }

    object Date {
        const val DAY = 1
        const val DAYS_IN_WEEK = 7
        const val DAYS_IN_MONTH = 31
        const val DAYS_IN_YEAR = 365

        const val EMPTY_DURATION = 0L
        const val MILLIS_IN_SECONDS = 1000L
        const val MILLIS_IN_MINUTE = 60000L
        const val MILLIS_IN_HOUR = 3600000L
        const val SECONDS_IN_MINUTE = 60L
        const val MINUTES_IN_MILLIS = 60000L
        const val MINUTES_IN_HOUR = 60L
        const val HOURS_IN_DAY = 24L

        const val minutesFormat = "%s%s"
        const val hoursFormat = "%s%s"
        const val hoursAndMinutesFormat = "%s%s %s%s"
    }
}