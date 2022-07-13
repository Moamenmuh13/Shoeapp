package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.nextBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.next_btn -> {
                navigateToNextFragment()
            }
        }
    }

    private fun navigateToNextFragment() {
        findNavController().navigate(R.id.action_instructionFragment_to_shoeFragment)
    }
}