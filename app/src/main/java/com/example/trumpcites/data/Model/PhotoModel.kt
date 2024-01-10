package com.example.trumpcites.data.Model

import com.example.trumpcites.data.DB.Model.PhotoEntity

data class PhotoModel(
    val id: Int = 0,
    val path: String,
) {
    fun toPhotoEntity(): PhotoEntity =
        PhotoEntity(
            id, path
        )
}