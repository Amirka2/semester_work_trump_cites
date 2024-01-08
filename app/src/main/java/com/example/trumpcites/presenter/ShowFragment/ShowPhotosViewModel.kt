package com.example.trumpcites.presenter.ShowFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trumpcites.data.Model.PhotoModel
import com.example.trumpcites.domain.GetPhotosUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowPhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
): ViewModel() {
    private val _paths = MutableLiveData<List<PhotoModel>>()
    val paths: LiveData<List<PhotoModel>>
        get() = _paths

    fun getPhotos() {
        viewModelScope.launch {
            getPhotosUseCase().collect() {
                _paths.postValue(it)
            }
        }
    }
}