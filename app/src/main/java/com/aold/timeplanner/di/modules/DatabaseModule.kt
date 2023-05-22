package com.aold.timeplanner.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Module
class DataBaseModule {

    // LocalDataSources

    @Provides
    @Singleton
    fun provideTemplatesLocalDataSource(
        dao: TemplatesDao,
    ): TemplatesLocalDataSource = TemplatesLocalDataSource.Base(dao)

    @Provides
    @Singleton
    fun provideThemeSettingsLocalDataSource(
        dao: ThemeSettingsDao,
    ): ThemeSettingsLocalDataSource = ThemeSettingsLocalDataSource.Base(dao)

    @Provides
    @Singleton
    fun provideCategoriesLocalDataSource(
        dao: MainCategoriesDao,
    ): CategoriesLocalDataSource = CategoriesLocalDataSource.Base(dao)

    @Provides
    @Singleton
    fun provideSubCategoriesLocalDataSource(
        dao: SubCategoriesDao,
    ): SubCategoriesLocalDataSource = SubCategoriesLocalDataSource.Base(dao)

    @Provides
    @Singleton
    fun provideSchedulesLocalDataSource(
        schedulesDao: SchedulesDao,
    ): SchedulesLocalDataSource = SchedulesLocalDataSource.Base(schedulesDao)

    // Dao

    @Provides
    @Singleton
    fun provideThemeSettingsDao(dataBase: SettingsDataBase): ThemeSettingsDao =
        dataBase.fetchThemeSettingsDao()

    @Provides
    @Singleton
    fun provideTemplatesDao(dataBase: SchedulesDataBase): TemplatesDao =
        dataBase.fetchTemplatesDao()

    @Provides
    @Singleton
    fun provideMainCategoriesDao(dataBase: SchedulesDataBase): MainCategoriesDao =
        dataBase.fetchMainCategoriesDao()

    @Provides
    @Singleton
    fun provideSubCategoriesDao(dataBase: SchedulesDataBase): SubCategoriesDao =
        dataBase.fetchSubCategoriesDao()

    @Provides
    @Singleton
    fun provideScheduleDao(dataBase: SchedulesDataBase): SchedulesDao =
        dataBase.fetchSchedulesDao()

    // DataBases

    @Provides
    @Singleton
    fun provideSettingsDataBase(
        @ApplicationContext context: Context,
    ): SettingsDataBase = Room.databaseBuilder(
        context = context,
        klass = SettingsDataBase::class.java,
        name = SettingsDataBase.NAME,
    ).createFromAsset("database/settings_prepopulated.db").build()

    @Provides
    @Singleton
    fun provideSchedulesDataBase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context = context,
        klass = SchedulesDataBase::class.java,
        name = SchedulesDataBase.NAME,
    ).createFromAsset("database/main_categories_prepopulate.db").build()
}