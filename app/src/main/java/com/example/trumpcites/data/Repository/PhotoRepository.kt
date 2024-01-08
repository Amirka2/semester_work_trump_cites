package com.example.trumpcites.data.Repository

import com.example.trumpcites.data.DB.Model.PhotoEntity
import com.example.trumpcites.data.DB.PhotoDAO
import com.example.trumpcites.data.Model.PhotoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface PhotoRepository {
    suspend fun upsertPhoto(photo: PhotoModel)

    val getPhotos: Flow<List<PhotoModel>>

    suspend fun deletePhotoById(id: Int)
}

class PhotoRepositoryImpl @Inject constructor(
    private val photoDAO: PhotoDAO
): PhotoRepository {
    override val getPhotos: Flow<List<PhotoModel>>
        get() = photoDAO.getPhotos().map { it.map {
            it.toPhotoModel()
        } }

    override suspend fun upsertPhoto(photo: PhotoModel) {
        photoDAO.upsertPhoto(photo.toPhotoEntity())
    }

    override suspend fun deletePhotoById(id: Int) {
        photoDAO.deletePhotoById(id)
    }

}