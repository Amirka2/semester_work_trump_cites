package com.example.trumpcites.domain

import com.example.trumpcites.data.Repository.PhotoRepository
import javax.inject.Inject

interface DeletePhotoUseCase {
    suspend operator fun invoke(id: Int)
}

class DeletePhotoUseCaseImpl @Inject constructor(
    private val repository: PhotoRepository
): DeletePhotoUseCase {
    override suspend fun invoke(id: Int) = repository.deletePhotoById(id)
}