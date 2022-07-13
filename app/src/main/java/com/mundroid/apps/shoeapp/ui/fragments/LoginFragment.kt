package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.signupBtn.setOnClickListener(this)
        binding.signinBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.signupBtn -> {
                navigateToNextFragment()
            }
            R.id.signinBtn -> {
                navigateToNextFragment()
            }
        }
    }

    private fun navigateToNextFragment() {
     findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }
}