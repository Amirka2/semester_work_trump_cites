package com.example.trumpcites.presenter.HomeFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trumpcites.R
import com.example.trumpcites.databinding.FragmentGetPhotoBinding
import com.example.trumpcites.di.ViewModelFactory
import com.example.trumpcites.di.appComponent
import javax.inject.Inject

private const val mImageAddress = "https://tronalddump.io/random/meme"

class HomeFragment: Fragment(R.layout.fragment_get_photo) {
    private val binding: FragmentGetPhotoBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels() {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getButton.setOnClickListener {
            viewModel.getPhoto(binding.memeImage, mImageAddress)
        }

        binding.saveButton.setOnClickListener {
            viewModel.savePhoto(binding.memeImage, requireContext())
        }
    }
}