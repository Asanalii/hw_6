package com.example.animation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animation.repository.City
import com.example.animation.repository.CityRepository

class CityViewModel(
    private val repository: CityRepository
): ViewModel() {
    private var _cityListLiveData = MutableLiveData<List<City>>()
    var cityListLiveData: LiveData<List<City>> = _cityListLiveData

    init {
        getData()
    }

    private fun getData(){
        val data = repository.getCityList()
        _cityListLiveData.postValue(data)
    }
}