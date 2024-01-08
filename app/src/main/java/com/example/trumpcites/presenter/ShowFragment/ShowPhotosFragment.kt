package com.example.trumpcites.presenter.ShowFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

    private val adapter = ShowPhotosAdapter()

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
            // TODO получать фотки в адаптере или фрагменте, что лучше?
            // TODO Создать хмл для одного элемента списка фотки
            // TODO сделать кнопку выхода с экрана 2 на экран 1
            // TODO сделать хоум фрагмент по подобию шоуфотос
            // TODO пример работы с апи в лессон 11.11
        }

        viewModel.paths.observe(viewLifecycleOwner) {
            val list = mutableListOf<String>()
            for (photo in it) {
                list.add(photo.path)
            }
        }

        // доставание фоток из памяти
    }
}