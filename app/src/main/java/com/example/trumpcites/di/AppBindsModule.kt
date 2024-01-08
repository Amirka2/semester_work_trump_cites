package com.example.trumpcites.di

import android.app.Application
import android.content.Context
import com.example.trumpcites.data.Repository.PhotoRepository
import com.example.trumpcites.data.Repository.PhotoRepositoryImpl
import com.example.trumpcites.domain.DeletePhotoUseCase
import com.example.trumpcites.domain.DeletePhotoUseCaseImpl
import com.example.trumpcites.domain.GetPhotosUseCase
import com.example.trumpcites.domain.GetPhotosUseCaseImpl
import com.example.trumpcites.domain.SavePhotoUseCase
import com.example.trumpcites.domain.SavePhotoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppBindsModule {
    @Binds
    @Singleton
    fun bindReceiptRepository(repositoryImpl: PhotoRepositoryImpl): PhotoRepository

    @Binds
    fun bindDeletePhotoUseCase(useCase: DeletePhotoUseCaseImpl): DeletePhotoUseCase

    @Binds
    fun bindGetPhotosUseCase(useCase: GetPhotosUseCaseImpl): GetPhotosUseCase

    @Binds
    fun bindSavePhotoUseCase(useCase: SavePhotoUseCaseImpl): SavePhotoUseCase

    companion object {
        @Provides
        fun provideContext(app: Application): Context =
            app.applicationContext
    }

}
