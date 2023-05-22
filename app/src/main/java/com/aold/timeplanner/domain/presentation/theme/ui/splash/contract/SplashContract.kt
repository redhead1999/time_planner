package com.aold.timeplanner.domain.presentation.theme.ui.splash.contract

import kotlinx.parcelize.Parcelize

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Parcelize
class SplashContract : SplashViewState: BaseViewState {
    object Default : SplashViewState()
}

sealed class SplashEvevnt : BaseEvevnt {
    object Init : SplashEvevnt()
}

sealed class SplashEffect: EmptyUiEffect

sealed class SplashAction: SplashEffect(), BaseAction