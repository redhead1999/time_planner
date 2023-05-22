package com.aold.timeplanner.application

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.aold.core.utils.functional.Constants
import com.aold.core.utils.notifications.parameters.NotificationPriority
import com.aold.timeplanner.di.component.AppComponent

/**
 * @author Kirilin Yury on 20.05.2023.
 */
class TimePlannerApp: Application() {

    val appComponent by lazy{
        appComponent.fetchNotificationCreator()
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createTimeTaskNotifyChannel()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createTimeTaskNotifyChannel() = notificationCreator.createNotifyChannel(
        channelId = Constants.Notification.CHANNEL_ID,
        channelName = coreStrings.timeTaskChannelName,
        priority = NotificationPriority.MAX,
    )

    fun Context.fetchApp(): TimePlannerApp {
        return applicationContext as TimePlannerApp
    }

    @Composable
    fun fetchAppComponent() {
        return LocalContext.current.fetchApp().appComponent
    }
}