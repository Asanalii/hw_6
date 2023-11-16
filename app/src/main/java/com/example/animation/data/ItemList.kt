package com.example.animation.data

import com.example.animation.ActionListDTO
import com.example.animation.R

object ItemList {
    val listActions = listOf(
        ActionListDTO("Улица", R.drawable.ic_street, "Что что что что", 0),
        ActionListDTO("Реклама", R.drawable.ic_advertisement, "Что что что что что", 1),
        ActionListDTO(
            "Статуя свободы1",
            R.drawable.ic_freedom1,
            "Ста́туя Свобо́ды1 — колоссальная скульптура, расположенная в США на острове Свободы, находящемся в Верхней Нью-Йоркской бухте, примерно в трёх километрах к юго-западу от южной окраины острова Манхэттен"
            ,2),
        ActionListDTO(
            "Статуя свободы2",
            R.drawable.ic_freedom2,
            "Ста́туя Свобо́ды2 — колоссальная скульптура, расположенная в США на острове Свободы, находящемся в Верхней Нью-Йоркской бухте, примерно в трёх километрах к юго-западу от южной окраины острова Манхэттен"
            ,3),
        ActionListDTO("Пёсик", R.drawable.ic_dog, "Что что что что что",4),
        ActionListDTO("Мост", R.drawable.ic_bridge, "Что что что что что",5),
    )
}