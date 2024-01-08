package com.example.trumpcites.domain

import com.example.trumpcites.data.Model.PhotoModel
import com.example.trumpcites.data.Repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPhotosUseCase {
    operator fun invoke(): Flow<List<PhotoModel>>
}

class GetPhotosUseCaseImpl @Inject constructor(
    private val repository: PhotoRepository
): GetPhotosUseCase {
    override fun invoke() = repository.getPhotos
}