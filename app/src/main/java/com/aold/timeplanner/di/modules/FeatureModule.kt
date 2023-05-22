package com.aold.timeplanner.di.modules

import dagger.Module
import dagger.Provides

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
class FeatureModule {

    @Provides
    fun provideHomeFeatureStarter(
        dependencies: HomeFeatureDependencies,
    ) = with(HomeComponentHolder) {
        init(dependencies)
        fetchApi().fetchStarter()
    }

    @Provides
    fun provideAnalyticsFeatureStarter(
        dependencies: AnalyticsFeatureDependencies,
    ) = with(AnalyticsComponentHolder) {
        init(dependencies)
        fetchApi().fetchStarter()
    }

    @Provides
    fun provideEditorFeatureStarter(
        dependencies: EditorFeatureDependencies,
    ) = with(EditorComponentHolder) {
        init(dependencies)
        fetchApi().fetchStarter()
    }

    @Provides
    fun provideSettingsFeatureStarter(
        dependencies: SettingsFeatureDependencies,
    ) = with(SettingsComponentHolder) {
        init(dependencies)
        fetchApi().fetchStarter()
    }
}