package com.aold.timeplanner.di.modules

import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
interface DependenciesModule {

    @Binds
    fun bindHomeFeatureDependencies(component: AppComponent): HomeFeatureDependencies

    @Binds
    fun bindEditorFeatureDependencies(component: AppComponent): EditorFeatureDependencies

    @Binds
    fun bindAnalyticsFeatureDependencies(component: AppComponent): AnalyticsFeatureDependencies

    @Binds
    fun bindSettingsFeatureDependencies(component: AppComponent): SettingsFeatureDependencies
}