package com.example.animation.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animation.CityAdapterAcrhitecture
import com.example.animation.databinding.FragmentCityBinding
import com.example.animation.mvvm.CityMvvmFragmentDirections
import com.example.animation.repository.City

class CityMvpFragment: Fragment(), CityScreen.View {
    private lateinit var binding: FragmentCityBinding
    private val adapter: CityAdapterAcrhitecture = CityAdapterAcrhitecture()
    private lateinit var presenter: CityScreen.Presenter

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

        presenter = CityPresenter(this)

        binding.listAction.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.listAction.adapter = adapter

        adapter.itemClick = { it, extras ->
            presenter.openDetails(it)
            findNavController().navigate(
                CityMvpFragmentDirections.actionCityMvpFragmentToCityInfoFragment(it.id), extras
            )
        }
    }
    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(list: List<City>) {
        adapter.submitList(list)
    }
}