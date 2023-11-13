package com.example.animation.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.animation.ActionListDTO

abstract class BaseViewHolder<VB: ViewBinding>(protected open val binding: VB):
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: ActionListDTO)
}
