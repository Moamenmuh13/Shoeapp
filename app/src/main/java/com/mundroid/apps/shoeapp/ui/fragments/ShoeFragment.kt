package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentShoeBinding

class ShoeFragment : Fragment() {
    private lateinit var binding: FragmentShoeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe, container, false)
        return binding.root
    }
}