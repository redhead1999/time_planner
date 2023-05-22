package com.aold.timeplanner.di.modules

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
interface CoreModule {

    @Binds
    fun bindAlarmReceiverProvider(provider: AlarmReceiverProviderImpl): AlarmReceiverProvider

    @Binds
    fun bindNotificationCreator(creator: NotificationCreator.Base): NotificationCreator

    @Binds
    @Singleton
    fun bindCoroutineManager(manager: CoroutineManager.Base): CoroutineManager

    @Binds
    @Singleton
    fun bindAppNavigationManager(manager: GlobalNavigationManager.Base): GlobalNavigationManager

    @Binds
    @Singleton
    fun bindTabNavigationManager(manager: TabNavigationManager.Base): TabNavigationManager

    @Binds
    fun bindTimeTaskAlarmManager(manager: TimeTaskAlarmManager.Base): TimeTaskAlarmManager

    @Binds
    @Singleton
    fun bindTimeOverlayManager(manager: TimeOverlayManager.Base): TimeOverlayManager

    @Binds
    fun bindTimeTaskStatusManager(manager: TimeTaskStatusManager.Base): TimeTaskStatusManager

    @Binds
    fun bindScheduleStatusManager(manager: ScheduleStatusManager.Base): ScheduleStatusManager

    @Binds
    fun bindDateManager(interactor: DateManager.Base): DateManager
}