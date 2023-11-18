package com.example.animation.repository

import androidx.annotation.DrawableRes

data class City(
    val title: String,
    @DrawableRes
    val pic: Int,
    val description: String? = null,
    val id: Int
)
