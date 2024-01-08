package com.example.trumpcites.data.DB.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trumpcites.data.Model.PhotoModel

@Entity(tableName = "photos")
data class PhotoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val path: String,
    ) {
    fun toPhotoModel(): PhotoModel =
        PhotoModel(
            id, path
        )
}