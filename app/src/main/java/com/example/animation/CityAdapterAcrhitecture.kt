package com.example.animation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animation.databinding.CityExampleBinding
import com.example.animation.repository.City

class CityAdapterAcrhitecture: ListAdapter<City, CityAdapterAcrhitecture.CityViewHolder>(CityDiffUtils) {
    var itemClick: ((City, FragmentNavigator.Extras)-> Unit)? = null

    object CityDiffUtils : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }
    }

    inner class CityViewHolder(
        private val binding: CityExampleBinding,
//        private val itemClick: ((ActionListDTO, FragmentNavigator.Extras) -> Unit)?,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: City) {
            binding.image.setImageResource(item.pic)
            binding.title.text = item.title

            binding.image.transitionName = item.id.toString()
            binding.title.transitionName = item.title + item.id.toString()

            val extras = FragmentNavigatorExtras(
                binding.image to "actionImage",
                binding.title to "actionTitle"
            )

                itemView.setOnClickListener {
                    itemClick?.invoke(item, extras)
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            CityExampleBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}