package com.example.animation.study

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.animation.databinding.FragmentViewAnimationBinding

class ViewAnimationFragment:Fragment() {
    private lateinit var binding: FragmentViewAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewAnimationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding){

            transition.setOnClickListener {
                container.animate()
                    .translationX(200f)
                    .setDuration(500)
                    .start()
            }

            scale.setOnClickListener {
                container.animate()
                    .scaleX(0.5f)
                    .scaleY(0.5f)
                    .setDuration(500)
                    .start()
            }

            rotation.setOnClickListener {
                container.animate()
                    .rotation(45f)
                    .setDuration(500)
                    .start()
            }

            setAnimation.setOnClickListener {
                val animation = AnimatorSet()

                val translation = ObjectAnimator.ofFloat(binding.container, View.TRANSLATION_X, 100f)
                val rotation = ObjectAnimator.ofFloat(binding.container, View.ROTATION_X, 180f)
                val alpha = ObjectAnimator.ofFloat(binding.container, View.ALPHA, 0.5f)

                animation.duration = 800
                animation.play(translation).before(rotation).with(alpha)

                animation.start()
            }

            reset.setOnClickListener {
                container.animate()
                    .rotation(0f)
                    .translationX(0f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(500)
                    .start()
            }

            next.setOnClickListener {
//                findNavController().navigate(com.example.animation.ViewAnimationFragmentDirections.actionViewAnimationFragmentToSharedStartFragment())
            }
        }
    }
}