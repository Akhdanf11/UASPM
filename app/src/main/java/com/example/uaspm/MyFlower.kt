package com.example.uaspm

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyFlower(
    var photo: Int,
    var name: String,
): Parcelable
