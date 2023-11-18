package com.example.animation.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animation.CityAdapter
import com.example.animation.CityAdapterAcrhitecture
import com.example.animation.CityFragmentDirections
import com.example.animation.databinding.FragmentCityBinding
import com.example.animation.repository.CityRepositoryImpl

class CityMvvmFragment:Fragment()  {
    private lateinit var binding: FragmentCityBinding
    private val adapter: CityAdapterAcrhitecture = CityAdapterAcrhitecture()
    private val viewModel: CityViewModel = CityViewModel(CityRepositoryImpl())

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
        binding.listAction.adapter = adapter

        binding.listAction.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

        adapter.itemClick = { item, extras ->
            findNavController().navigate(
                CityMvvmFragmentDirections.actionCityMvvmFragmentToCityInfoFragment(item.id), extras
            )
        }

        viewModel.cityListLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }
}