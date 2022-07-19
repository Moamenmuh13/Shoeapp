package com.mundroid.apps.shoeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Shoe(
    var shoeName: String = "",
    var shoeSize: String = "",
    var companyName: String = "",
    var description: String = "",

    ):Parcelable

