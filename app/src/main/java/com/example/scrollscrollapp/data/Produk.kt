package com.example.scrollscrollapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produk(
    val image:String,
    val title:String,
    val miniDesc:String,
    val desc:String
):Parcelable
