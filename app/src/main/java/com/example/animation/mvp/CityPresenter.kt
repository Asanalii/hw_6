package com.example.animation.mvp

import com.example.animation.repository.City
import com.example.animation.repository.CityRepository
import com.example.animation.repository.CityRepositoryImpl

class CityPresenter(
    private val view: CityScreen.View
): CityScreen.Presenter {
    private val repository: CityRepository = CityRepositoryImpl()

    init {
        getData()
    }
    override fun getData() {
        val data = repository.getCityList()
        view.showData(data)
    }

    override fun openDetails(city: City) {
        view.showMessage(city.title.toString())
    }
}