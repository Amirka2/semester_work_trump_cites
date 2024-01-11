package com.example.trumpcites.data.DB

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.trumpcites.data.DB.Model.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDAO {
    @Upsert
    suspend fun upsertPhoto(photo: PhotoEntity)

    @Query("SELECT * FROM photos")
    fun getPhotos(): Flow<List<PhotoEntity>>

    @Query("DELETE FROM photos WHERE id=:id")
    suspend fun deletePhotoById(id: Int)
}