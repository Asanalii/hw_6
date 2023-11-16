package com.example.animation

import android.animation.AnimatorSet
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.animation.data.ItemList
import com.example.animation.databinding.FragmentCityBinding
import com.example.animation.databinding.FragmentCityInfoBinding

class CityInfoFragment:Fragment() {
    private lateinit var binding: FragmentCityInfoBinding
    private val args: CityInfoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val adapter = CityAdapter(ItemList.listActions)


        val item = ItemList.listActions.find {
            it.id == args.id
        }

        item?.let {
            binding.newYork.text = it.title
            binding.image.setImageResource(it.pic)
        }

        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)

        binding.image.setOnClickListener {
            binding.image.animate()
                .rotation(360f)
                .setDuration(2000)
                .start()
        }
    }


}