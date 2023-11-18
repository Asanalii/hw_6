package com.example.animation.repository

import com.example.animation.R

class CityRepositoryImpl:CityRepository {
    private var cityList: List<City> = listOf()
    override fun getCityList(): List<City> {
        return cityList.ifEmpty { getRemoteCity() }
    }

    private fun getRemoteCity():List<City>{
        val list: MutableList<City> = mutableListOf(
            City("Улица", R.drawable.ic_street, "Что что что что", 0),
            City("Реклама", R.drawable.ic_advertisement, "Что что что что что", 1),
            City(
                "Статуя свободы1",
                R.drawable.ic_freedom1,
                "Ста́туя Свобо́ды1 — колоссальная скульптура, расположенная в США на острове Свободы, находящемся в Верхней Нью-Йоркской бухте, примерно в трёх километрах к юго-западу от южной окраины острова Манхэттен"
                ,2),
            City(
                "Статуя свободы2",
                R.drawable.ic_freedom2,
                "Ста́туя Свобо́ды2 — колоссальная скульптура, расположенная в США на острове Свободы, находящемся в Верхней Нью-Йоркской бухте, примерно в трёх километрах к юго-западу от южной окраины острова Манхэттен"
                ,3),
            City("Пёсик", R.drawable.ic_dog, "Что что что что что",4),
            City("Мост", R.drawable.ic_bridge, "Что что что что что",5),
        )
        cityList = list

        return list
    }
}