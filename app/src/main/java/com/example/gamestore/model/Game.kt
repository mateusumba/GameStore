package com.example.gamestore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int,
    val purchasableItems: List<PurchasableItem>
) : Parcelable