package com.aold.timeplanner.domain.interactors

import com.aold.core.utils.functional.Either
import com.aold.timeplanner.domain.common.MainEitherWrapper
import com.aold.timeplanner.domain.common.MainFailures
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface SettingsInteractor{
    suspend fun fetchThemeSettings(): Flow<Either<MainFailures, ThemeSettings>>

    class Base @Inject constructor(
        private val settingsRepository: ThemeSettingsRepository,
        private val eitherWrapper: MainEitherWrapper
    ): SettingsInteractor{
        override suspend fun fetchThemeSettings() = eitherWrapper.wrapFlow {
            settingsRepository.fetchSettingsFlow()
        }
    }
}