package com.example.trumpcites.presenter.ShowFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trumpcites.R
import com.example.trumpcites.databinding.FragmentShowPhotosBinding
import com.example.trumpcites.di.ViewModelFactory
import com.example.trumpcites.di.appComponent
import javax.inject.Inject

class ShowPhotosFragment: Fragment(R.layout.fragment_show_photos) {
    private val binding: FragmentShowPhotosBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val adapter = ShowPhotosAdapter(::onDeleteClick)

    private val viewModel: ShowPhotosViewModel by viewModels() {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.photosRecycler) {
            adapter = this@ShowPhotosFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.paths.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.getPhotos()

        binding.topNavbar.setOnMenuItemClickListener {
            findNavController().popBackStack()
        }
    }

    private fun onDeleteClick(photoId: Int) {
        viewModel.deletePhoto(photoId)
    }
}