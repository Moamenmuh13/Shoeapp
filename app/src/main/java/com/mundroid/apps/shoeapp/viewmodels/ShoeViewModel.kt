package com.mundroid.apps.shoeapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mundroid.apps.shoeapp.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()


    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf()
    }

    fun getShoesList(): LiveData<MutableList<Shoe>> = shoeList

    fun addShoes(shoe: Shoe?) {
        if (shoe != null) {
            shoeList.value!!.add(shoe)
        }
    }
}