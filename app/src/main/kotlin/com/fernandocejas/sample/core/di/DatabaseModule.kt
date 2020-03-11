package com.fernandocejas.sample.core.di

import android.content.Context
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDao
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRecentDao(app: MindValleyDatabase): MindValleyDao = app.mindValleyDao()
}