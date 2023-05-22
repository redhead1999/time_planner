package com.aold.timeplanner.di.modules

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
interface DataModule {

    // Repositories

    @Singleton
    @Binds
    fun bindTemplatesRepository(repository: TemplatesRepositoryImpl): TemplatesRepository

    @Binds
    @Singleton
    fun bindTimeTaskRepository(repository: TimeTaskRepositoryImpl): TimeTaskRepository

    @Binds
    @Singleton
    fun bindThemeSettingsRepository(repository: ThemeSettingsRepositoryImpl): ThemeSettingsRepository

    @Binds
    @Singleton
    fun bindScheduleRepository(repository: ScheduleRepositoryImpl): ScheduleRepository

    @Binds
    @Singleton
    fun bindSubCategoriesRepository(repository: SubCategoriesRepositoryImpl): SubCategoriesRepository

    @Binds
    @Singleton
    fun bindCategoriesRepository(repository: CategoriesRepositoryImpl): CategoriesRepository

    // Mappers

    @Binds
    fun bindScheduleDataToDomainMapper(mapper: ScheduleDataToDomainMapper.Base): ScheduleDataToDomainMapper

    @Binds
    fun bindTemplatesDataToDomain(mapper: TemplatesDataToDomainMapper.Base): TemplatesDataToDomainMapper

    @Binds
    fun bindTemplatesDomainToData(mapper: TemplatesDomainToDataMapper.Base): TemplatesDomainToDataMapper
}