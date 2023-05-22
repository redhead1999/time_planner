package com.aold.timeplanner.di.component

import android.content.Context
import dagger.Component
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */

@Singleton
@Component(
    modules =
        [
            DataBaseModule::class,
            DataModule::class,
            NavigationModule::class,
            CoreModule::class,
            PresentationModule::class,
            DomainModules::class,
            DependenciesModule::class,
            FeatureModule::class,
        ]
)
interface AppComponent:  HomeFeatureDependencies,
    SettingsFeatureDependencies,
    EditorFeatureDependencies,
    AnalyticsFeatureDependencies {
    @TabNavigation
    fun fetchTabNavigatorManager(): NavigatorManager
    fun fetchSplashScreenModel(): SplashScreenModel
    fun fetchTabScreenModel(): TabScreenModel
    fun fetchNotificationCreator(): NotificationCreator
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder
        fun navigationModule(module: NavigationModule): Builder
        fun featureModule(module: FeatureModule): Builder
        fun dataBaseModule(module: DataBaseModule): Builder
        fun build(): AppComponent
    }

    companion object {
        fun create(context: Context): AppComponent {
            return DaggerAppComponent.builder()
                .applicationContext(context)
                .navigationModule(NavigationModule())
                .featureModule(FeatureModule())
                .dataBaseModule(DataBaseModule())
                .build()
        }
    }
}
    }