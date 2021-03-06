package com.mundroid.apps.shoeapp.ui.fragments

import android.os.Bundle
import android.view.*
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
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        initViews()
        setHasOptionsMenu(true)
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


    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu , inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu_item -> {
                findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToLoginFragment())

            }
        }
        return super.onOptionsItemSelected(item)
    }
}