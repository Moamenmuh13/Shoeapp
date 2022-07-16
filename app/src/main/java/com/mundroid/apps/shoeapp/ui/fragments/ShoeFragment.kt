package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentShoeBinding
import com.mundroid.apps.shoeapp.viewmodels.ShoeViewModel

class ShoeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentShoeBinding
    private lateinit var shoeViewModel: ShoeViewModel
    private val args: ShoeFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        shoeViewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe, container, false)
        binding.lifecycleOwner = this
        binding.shoeViewModel = shoeViewModel


        if (args != null){
            val name = args.shoeName

            binding.shoeName.text = name

        }
        else
            Toast.makeText(requireContext(), "empty", Toast.LENGTH_SHORT).show()

        initViews()
        return binding.root
    }


    private fun initViews() {

        binding.floatingBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.floating_btn -> {
                nextFragment()
            }
        }
    }

    private fun nextFragment() {
        findNavController().navigate(R.id.action_shoeFragment_to_shoeDetailsFragment)

    }
}