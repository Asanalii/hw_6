package com.example.animation.study

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.animation.databinding.FragmentSharedEndBinding

class SharedEndFragment:Fragment() {
    private lateinit var binding: FragmentSharedEndBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSharedEndBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)

        binding.next.setOnClickListener {
//            findNavController().navigate(com.example.animation.SharedEndFragmentDirections.actionSharedEndFragmentToMotionFragment())
        }
    }
}