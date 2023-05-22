package com.aold.timeplanner.domain.navigation

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface TabNavigationManager {

    fun showHomeFeature()
    fun showHomeScreen()
    fun showTemplatesScreen()
    fun showCategoriesScreen()
    fun showAnalyticsFeature()
    fun showSettingsFeature()

    class Base @Inject constructor(
        private val homeFeatureStarter: Provider<HomeFeatureStarter>,
        private val analyticsFeatureStarter: Provider<AnalyticsFeatureStarter>,
        private val settingsFeatureStarter: Provider<SettingsFeatureStarter>,
        private val router: TabRouter,
    ) : TabNavigationManager {

        override fun showHomeFeature() = showTab(
            screen = homeFeatureStarter.get().provideNavScreen(),
        )

        override fun showHomeScreen() = showHomeFeature().let {
            homeFeatureStarter.get().showHomeScreen()
        }

        override fun showTemplatesScreen() = showHomeFeature().let {
            homeFeatureStarter.get().showTemplatesScreen()
        }

        override fun showCategoriesScreen() = showHomeFeature().let {
            homeFeatureStarter.get().showCategoriesScreen()
        }

        override fun showAnalyticsFeature() = showTab(
            screen = analyticsFeatureStarter.get().provideMainScreen(),
        )

        override fun showSettingsFeature() = showTab(
            screen = settingsFeatureStarter.get().provideMainScreen(),
        )

        private fun showTab(screen: Screen) = router.showTab(screen)
    }
}