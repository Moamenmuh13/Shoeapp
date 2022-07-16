package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentShoeDetailsBinding
import com.mundroid.apps.shoeapp.models.Shoe

class ShoeDetailsFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentShoeDetailsBinding


    private  val TAG = "ShoeDetailsFragment"
    private val arrayList: ArrayList<Shoe> = ArrayList<Shoe>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.saveButton.setOnClickListener(this)
        binding.cancelButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.save_button -> {
                sendShoeDetails()
            }
            R.id.cancel_button -> {
            }
        }
    }

    private fun sendShoeDetails() {

        val shoeName = binding.shoeNameEditText.text.toString()
        val companyName = binding.companyNameEditText.text.toString()
        val shoeSize = binding.shoeSizeEditText.text.toString().toInt()
        val description = binding.descriptionEditText.text.toString()

        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeFragment(
            shoeName,
            companyName,
            shoeSize,
            description))


        Log.d(TAG, "sendShoeDetails: $shoeName+$companyName,$description")
    }

}