package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentShoeDetailsBinding
import com.mundroid.apps.shoeapp.models.Shoe
import com.mundroid.apps.shoeapp.viewmodels.ShoeViewModel

class ShoeDetailsFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentShoeDetailsBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private var isDataValid: Boolean = false
    var shoeName: String? = null
    var shoeSize: String? = null
    var companyName: String? = null
    var description: String? = null

    private val TAG = "ShoeDetailsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        initViews()
        setHasOptionsMenu(true)

        return binding.root
    }


    private fun initViews() {
        binding.saveButton.setOnClickListener(this)
        binding.cancelButton.setOnClickListener(this)
        binding.shoe = Shoe()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.save_button -> {
                if (!isDataValid == addShoeDetails()) {
                    addingData()
                } else
                    Toast.makeText(requireContext(), "Add all details plz", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.cancel_button -> {
                clearData()
                closeFragment()
            }
        }
    }

    private fun addShoeDetails(): Boolean {

        if (!(binding.shoeNameEditText.text.toString()
                .isNotEmpty() && binding.shoeSizeEditText.text.toString()
                .isNotEmpty() && binding.companyNameEditText.text.toString().isNotEmpty()
                    && binding.descriptionEditText.text.toString().isNotEmpty())
        ) {
            return isDataValid

        }
        return !isDataValid
    }

    private fun addingData() {

        shoeName = binding.shoeNameEditText.text.toString()
        shoeSize = binding.shoeSizeEditText.text.toString() + ": Size"
        companyName = binding.companyNameEditText.text.toString()
        description = binding.descriptionEditText.text.toString()

        shoeViewModel.addShoes(Shoe(shoeName!!, shoeSize!!, companyName!!, description!!))
        closeFragment()
    }

    private fun closeFragment() {

        requireView().findNavController()
            .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeFragment())

    }

    private fun clearData() {
        shoeName = binding.shoeNameEditText.text!!.clear().toString()
        shoeSize = binding.shoeSizeEditText.text!!.clear().toString()
        companyName = binding.companyNameEditText.text!!.clear().toString()
        description = binding.descriptionEditText.text!!.clear().toString()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu_item -> {
//                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToLoginFragment())

            }
        }
        return super.onOptionsItemSelected(item)
    }
}