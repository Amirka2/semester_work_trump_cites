package com.example.trumpcites.domain

import com.example.trumpcites.data.Model.PhotoModel
import com.example.trumpcites.data.Repository.PhotoRepository
import javax.inject.Inject

interface SavePhotoUseCase {
    suspend operator fun invoke(photo: PhotoModel)
}

class SavePhotoUseCaseImpl @Inject constructor(
    private val repository: PhotoRepository
): SavePhotoUseCase {
    override suspend fun invoke(photo: PhotoModel) = repository.upsertPhoto(photo)
}