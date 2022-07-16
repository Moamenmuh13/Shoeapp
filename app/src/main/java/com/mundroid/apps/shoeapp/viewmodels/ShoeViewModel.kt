package com.mundroid.apps.shoeapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _companyName = MutableLiveData<String>()
    private val _shoeName = MutableLiveData<String>()
    private val _shoeSize = MutableLiveData<Int>()
    private val _description = MutableLiveData<String>()


    val companyName: LiveData<String>
        get() = _companyName

    val shoeName: LiveData<String>
        get() = _shoeName

    val shoeSize: LiveData<Int>
        get() = _shoeSize

    val description: LiveData<String>
        get() = _description


    init {

    }


}