package com.example.trumpcites.presenter.ShowFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.trumpcites.data.Model.PhotoModel
import com.example.trumpcites.databinding.FavoritePhotoItemBinding
import java.io.File

class ShowPhotosAdapter(
    private val onDeleteClick: (Int) -> Unit,
) : ListAdapter<PhotoModel, ShowPhotosAdapter.ShowPhotosViewHolder>(PhotoDiffUtil()) {

    class ShowPhotosViewHolder(
        private val binding: FavoritePhotoItemBinding,
        private val onDeleteClick: (Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PhotoModel) {
            val context = binding.root.context

            binding.imageView.load(File(data.path))
            binding.deleteIcon.setOnClickListener {
                onDeleteClick(data.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowPhotosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FavoritePhotoItemBinding.inflate(
            inflater,
            parent,
            false
        )

        return ShowPhotosViewHolder(binding, onDeleteClick)
    }

    override fun onBindViewHolder(holder: ShowPhotosViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PhotoDiffUtil: DiffUtil.ItemCallback<PhotoModel>() {
        override fun areItemsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean =
            oldItem == newItem

    }

}