package com.mundroid.apps.shoeapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mundroid.apps.shoeapp.models.Shoe

class ShoeViewModelRecycler : ViewModel() {

    private var _shoeMutableArrayList = MutableLiveData<ArrayList<Shoe>>()


    val shoeMutableArrayList: LiveData<ArrayList<Shoe>>
        get() = _shoeMutableArrayList


    init {
        _shoeMutableArrayList.value = setList()

    }


    private fun setList(): ArrayList<Shoe> {
        return arrayListOf(
//            Shoe("Jordan Air", 40.0, "Nike", "This is the best shoe in the store"),
//            Shoe("Jordan Air", 44.0, "Addidas", "This is the best shoe in the store"),
//            Shoe("All Stars", 42.0, "Converse", "This is the best shoe in the store"),
//            Shoe("Jordan Air", 42.0, "Nike", "This is the best shoe in the store"),
        )

    }
}