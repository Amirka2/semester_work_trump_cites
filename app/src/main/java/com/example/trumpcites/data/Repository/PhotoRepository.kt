package com.example.trumpcites.data.Repository

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import com.example.trumpcites.data.DB.PhotoDAO
import com.example.trumpcites.data.Model.PhotoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface PhotoRepository {
    suspend fun upsertPhoto(photo: PhotoModel)

    val getPhotos: Flow<List<PhotoModel>>

    suspend fun deletePhotoById(id: Int)

    fun getAndPutMeme(image: ImageView, url: String)
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

    override fun getAndPutMeme(image: ImageView, url: String) {
        image.load(url) {
            addHeader(
                "Accept",
                "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"
            )
            diskCachePolicy(CachePolicy.DISABLED)
            memoryCachePolicy(CachePolicy.DISABLED)
        }
    }
}