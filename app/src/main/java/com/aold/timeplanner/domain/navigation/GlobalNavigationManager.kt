package com.aold.timeplanner.domain.navigation

import com.aold.timeplanner.di.annotation.GlobalNavigation
import javax.inject.Inject

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface GlobalNavigationManager{

    fun showTabScreen()

    class Base @Inject constructor(private val  router: Router): GlobalNavigationManager{
        override fun showTabScreen() {
            router.replaceTo(TabsScreen())
        }
    }
}