package com.aold.timeplanner.domain.presentation.receiver

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.aold.core.utils.functional.Constants

/**
 * @author Kirilin Yury on 22.05.2023.
 */
class TimeTaskAlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent == null || context == null) return
            val notificationCreator = NotificationCreator.Base(context)

        if(intent.action = Constants.ALARM_NOTIFICATION_ACTION)

            if (intent.action == Constants.Alarm.ALARM_NOTIFICATION_ACTION) {
                val category = checkNotNull(intent.getStringExtra(Constants.Alarm.NOTIFICATION_CATEGORY))
                val subCategory = checkNotNull(intent.getStringExtra(Constants.Alarm.NOTIFICATION_SUBCATEGORY))
                val icon = intent.getIntExtra(Constants.Alarm.NOTIFICATION_ICON, 0)
                val appIcon = checkNotNull(intent.getIntExtra(Constants.Alarm.APP_ICON, 0))

                val activityIntent = Intent(context, MainActivity::class.java)
                val contentIntent = PendingIntent.getActivity(context, 0, activityIntent, PendingIntent.FLAG_IMMUTABLE)
                val notification = notificationCreator.createNotify(
                    channelId = Constants.Notification.CHANNEL_ID,
                    title = if (subCategory.isNotEmpty()) "$category, $subCategory" else category,
                    text = coreStrings.startTaskNotifyText,
                    smallIcon = appIcon,
                    largeIcon = if (icon != 0) ContextCompat.getDrawable(context, icon)?.toBitmap() else null,
                    autoCancel = true,
                    priority = NotificationPriority.MAX,
                    contentIntent = contentIntent,
                    color = ContextCompat.getColor(context, R.color.notification_icon),
                )
                notificationCreator.showNotify(notification, 0)
            }
    }
}

}
}