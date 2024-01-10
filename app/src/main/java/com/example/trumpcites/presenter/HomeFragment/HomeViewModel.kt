package com.example.trumpcites.presenter.HomeFragment

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Environment
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trumpcites.data.Model.PhotoModel
import com.example.trumpcites.domain.GetPhotoUseCase
import com.example.trumpcites.domain.SavePhotoUseCase
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase,
    private val savePhotoUseCase: SavePhotoUseCase
): ViewModel() {

    fun getPhoto(image: ImageView, url: String) {
        viewModelScope.launch {
            getPhotoUseCase(image, url)
        }
    }

    fun savePhoto(image: ImageView, context: Context) {
        val drawable = image.getDrawable()

        val path = saveImage(drawable, context)
        val photo = PhotoModel(path = path)

        viewModelScope.launch {
            savePhotoUseCase(photo)
        }
    }

    private fun saveImage(drawable: Drawable, context: Context): String {
        val file = getDisc()

        if (!file.exists() && !file.mkdirs()) {
            file.mkdir()
        }

        val simpleDateFormat = SimpleDateFormat("yyyymmsshhmmss")
        val date = simpleDateFormat.format(Date())
        val name = "IMG" + date + ".jpg"
        val fileName = file.absolutePath + "/" + name
        val newFile = File(fileName)
        var savedFile: File

        try {
            val draw = drawable as BitmapDrawable
            val bitmap = draw.bitmap
            val fileOutPutStream = FileOutputStream(newFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutPutStream)
            Toast.makeText(context, "File saved succesfully", Toast.LENGTH_SHORT)
                .show()
            savedFile = newFile
            fileOutPutStream.flush()
            fileOutPutStream.close()

            return savedFile?.absolutePath ?: ""
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            throw Error(e)
        } catch (e: IOException) {
            e.printStackTrace()
            throw Error(e)
        }
    }

    private fun getDisc(): File {
        val file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        return File(file, "YOUR_ALBUM_NAME")
    }
}