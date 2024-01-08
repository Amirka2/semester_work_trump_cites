package com.example.trumpcites.data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trumpcites.data.DB.Model.PhotoEntity

@Database(
    entities = [
        PhotoEntity::class,
    ],
    version = 1
)
abstract class PhotoDataBase: RoomDatabase() {
    abstract val photoDAO: PhotoDAO
}