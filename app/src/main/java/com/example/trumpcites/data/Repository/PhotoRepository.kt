package com.example.trumpcites.data.Repository

import com.example.trumpcites.data.DB.Model.PhotoEntity
import com.example.trumpcites.data.DB.PhotoDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface PhotoRepository {
    suspend fun upsertPhoto(photo: PhotoEntity)

//    val getPhotos(): Flow<List<PhotoEntity>>

    suspend fun deletePhotoById(id: Int)
}

class PhotoRepositoryImpl @Inject constructor(
    private val photoDAO: PhotoDAO
): PhotoRepository {
    override suspend fun upsertPhoto(photo: PhotoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhotoById(id: Int) {
        TODO("Not yet implemented")
    }

}