package com.example.animation.mvp

import com.example.animation.repository.City

sealed interface CityScreen {
    interface View {
        fun showMessage(message: String)
        fun showData(list: List<City>)
    }

    interface Presenter {
        fun getData()
        fun openDetails(city: City)

    }

}