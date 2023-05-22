package com.aold.timeplanner.di.modules

import com.aold.timeplanner.di.annotation.GlobalNavigation
import com.aold.timeplanner.di.annotation.TabNavigation
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
class NavigationModule {

    // Global Navigator

    @GlobalNavigation
    @Provides
    @Singleton
    fun provideGlobalNavigatorManager(
        @GlobalNavigation commandBuffer: CommandBuffer,
    ): NavigatorManager = NavigatorManager.Base(commandBuffer)

    @GlobalNavigation
    @Provides
    @Singleton
    fun provideGlobalCommandBuffer(): CommandBuffer = CommandBuffer.Base()

    @Provides
    @Singleton
    fun provideGlobalRouter(
        @GlobalNavigation commandBuffer: CommandBuffer,
    ): Router = Router.Base(commandBuffer)

    // Tab Navigator

    @TabNavigation
    @Provides
    @Singleton
    fun provideTabNavigatorManager(
        @TabNavigation commandBuffer: CommandBuffer,
    ): NavigatorManager = NavigatorManager.Base(commandBuffer)

    @TabNavigation
    @Provides
    @Singleton
    fun provideTabCommandBuffer(): CommandBuffer = CommandBuffer.Base()

    @Provides
    @Singleton
    fun provideTabRouter(
        @TabNavigation commandBuffer: CommandBuffer,
    ): TabRouter = TabRouter.Base(Router.Base(commandBuffer))
}