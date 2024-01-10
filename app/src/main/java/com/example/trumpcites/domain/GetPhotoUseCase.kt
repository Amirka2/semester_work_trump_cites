package com.example.trumpcites.domain

import android.widget.ImageView
import com.example.trumpcites.data.Repository.PhotoRepository
import javax.inject.Inject

interface GetPhotoUseCase {
    suspend operator fun invoke(image: ImageView, url: String)
}

class GetPhotoUseCaseImpl @Inject constructor(
    private val repository: PhotoRepository
): GetPhotoUseCase {
    override suspend fun invoke(image: ImageView, url: String) =
        repository.getAndPutMeme(image, url)
}