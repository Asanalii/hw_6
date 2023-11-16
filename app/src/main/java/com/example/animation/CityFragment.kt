package com.example.animation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animation.data.ItemList
import com.example.animation.databinding.FragmentCityBinding
import com.example.recyclerview.decoration.OffsetDecoration

class CityFragment: Fragment() {
    private lateinit var binding: FragmentCityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CityAdapter(ItemList.listActions)

        binding.listAction.adapter = adapter
        binding.listAction.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)


        adapter.itemClick = { item, extras ->

//            Log.d("ExtraCallsProvider")

            findNavController().navigate(
                CityFragmentDirections.actionCityFragmentToCityInfoFragment(item.id), extras
            )
        }
    }
//        binding.listAction.addItemDecoration(OffsetDecoration(0,3,10,3))
}


