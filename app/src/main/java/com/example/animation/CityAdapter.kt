package com.example.animation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.animation.base.BaseViewHolder
import com.example.animation.databinding.CityExampleBinding

class CityAdapter(
    private val items: List<ActionListDTO>
): RecyclerView.Adapter<BaseViewHolder<*>>() {
    var itemClick: ((ActionListDTO, FragmentNavigator.Extras)-> Unit)? = null
//    private var extras: FragmentNavigator.Extras? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ActionListViewHolder(
            CityExampleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.bindView(items[position])

        holder.itemView.setOnClickListener {
            val item = items[position]

//            val bundle = Bundle().apply {
//
//            }

            val extras = FragmentNavigatorExtras(
//                item.p to "container",
//                binding.title to "title",
//                binding.description to "description"
            )

//            it.findNavController().navigate(R.id.action_cityFragment_to_cityInfoFragment,)

        }
    }

    class ActionListViewHolder(
        override val binding: CityExampleBinding,
        private val itemClick: ((ActionListDTO, FragmentNavigator.Extras) -> Unit)?,
    ) : BaseViewHolder<CityExampleBinding>(binding) {

        override fun bindView(item: ActionListDTO) {
            binding.image.setImageResource(item.pic)
            binding.title.text = item.title

            val extras = FragmentNavigatorExtras(
                binding.image to "actionImage",
                binding.title to "actionTitle"
            )

            binding.image.setOnClickListener {
                itemClick?.invoke(item,extras)
            }

//            itemView.setOnClickListener {
//                itemClick?.invoke(item)
//            }
        }

    }

}




data class ActionListDTO(
    val title: String? = null,
    @DrawableRes
    val pic: Int,
    val description: String? = null
)