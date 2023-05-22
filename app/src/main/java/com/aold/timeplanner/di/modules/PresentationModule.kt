package com.aold.timeplanner.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
interface PresentationModule {

    // Main ViewModel

    @Binds
    fun bindMainViewModelFactory(factory: MainViewModel.Factory): ViewModelProvider.Factory

    @Binds
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @Singleton
    fun bindMainStateCommunicator(communicator: MainStateCommunicator.Base): MainStateCommunicator

    @Binds
    fun bindSettingsWorkProcessor(processor: SettingsWorkProcessor.Base): SettingsWorkProcessor

    // Splash ScreenModel

    @Binds
    @ScreenModelKey(SplashScreenModel::class)
    fun bindSplashScreenModel(screenModel: SplashScreenModel): ScreenModel

    @Binds
    @Singleton
    fun bindSplashStateCommunicator(communicator: SplashStateCommunicator.Base): SplashStateCommunicator

    // Tabs ScreenModel

    @Binds
    @ScreenModelKey(TabScreenModel::class)
    fun bindTabsScreenModel(screenModel: TabScreenModel): ScreenModel

    @Binds
    @Singleton
    fun bindTabsStateCommunicator(communicator: TabsStateCommunicator.Base): TabsStateCommunicator
}