package com.example.trumpcites.presenter.HomeFragment

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trumpcites.domain.GetPhotoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase
): ViewModel() {

    fun getPhoto(image: ImageView, url: String) {
        viewModelScope.launch {
            getPhotoUseCase(image, url)
        }
    }
}