package com.example.trumpcites.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trumpcites.presenter.HomeFragment.HomeViewModel
import com.example.trumpcites.presenter.ShowFragment.ShowPhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindMainViewModel(viewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowPhotosViewModel::class)
    fun bindAddPurchaseViewModel(viewModel: ShowPhotosViewModel) : ViewModel

}