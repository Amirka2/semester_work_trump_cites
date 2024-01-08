package com.example.trumpcites.di

import android.app.Application
import android.content.Context
import com.example.trumpcites.data.Repository.PhotoRepository
import com.example.trumpcites.data.Repository.PhotoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppBindsModule {
    @Binds
    @Singleton
    fun bindReceiptRepository(repositoryImpl: PhotoRepositoryImpl): PhotoRepository

    companion object {
        @Provides
        fun provideContext(app: Application): Context =
            app.applicationContext
    }

}
