package com.example.trumpcites.di

import android.content.Context
import androidx.room.Room
import com.example.trumpcites.data.DB.PhotoDAO
import com.example.trumpcites.data.DB.PhotoDataBase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {
    @Provides
    fun provideDataBase(context: Context): PhotoDataBase =
        Room.databaseBuilder(
            context,
            PhotoDataBase::class.java,
            "photos.db"
        ).build()

    @Provides
    fun provideReceiptDAO(db: PhotoDataBase): PhotoDAO =
        db.photoDAO

}