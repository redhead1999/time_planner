package com.aold.timeplanner.domain.presentation.theme.ui.main

import android.content.Intent
import android.window.SplashScreen
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import com.aold.core.utils.navigation.navigator.AppNavigator
import com.aold.core.utils.platform.activity.BaseActivity
import com.aold.core.utils.platform.screen.ScreenContent
import com.aold.timeplanner.di.annotation.GlobalNavigation
import javax.inject.Inject

/**
 * @author Kirilin Yury on 22.05.2023.
 */
class MainActivity : BaseActivity<MainViewState, MainEvent, MainAction, MainEffect>() {

    @Inject
    @GlobalNavigation
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var viewModelFactory: MainViewModel.Factory

    override fun initDI() = fetchApp().appComponent.inject(this)

    @Composable
    override fun Content() = ScreenContent(viewModel, MainViewState()) { state ->
        TimePlannerTheme(
            themeColorsType = state.colors,
            language = state.language,
        ) {
            AppNavigator(
                initialScreen = SplashScreen(),
                navigatorManager = navigatorManager,
                content = { CurrentScreen() },
            )
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun fetchViewModelFactory() = viewModelFactory

    override fun fetchViewModelClass() = MainViewModel::class.java
}