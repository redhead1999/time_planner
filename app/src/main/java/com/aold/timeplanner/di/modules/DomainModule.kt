package com.aold.timeplanner.di.modules

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
interface DomainModules {

    @Binds
    @Singleton
    fun bindSettingsInteractor(interactor: SettingsInteractor.Base): SettingsInteractor

    @Binds
    fun bindMainEitherWrapper(wrapper: MainEitherWrapper.Base): MainEitherWrapper

    @Binds
    fun bindMainErrorHandler(handler: MainErrorHandler.Base): MainErrorHandler
}