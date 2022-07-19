package com.mundroid.apps.shoeapp.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.SCROLL_AXIS_HORIZONTAL
import android.view.View.inflate
import android.widget.LinearLayout.HORIZONTAL
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.divider.MaterialDividerItemDecoration.HORIZONTAL
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.FragmentShoeBinding
import com.mundroid.apps.shoeapp.databinding.TicketShoeListBinding
import com.mundroid.apps.shoeapp.models.Shoe
import com.mundroid.apps.shoeapp.viewmodels.ShoeViewModel

class ShoeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentShoeBinding
    private lateinit var ticketShoeListBinding: TicketShoeListBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe, container, false)
        ticketShoeListBinding =
            TicketShoeListBinding.inflate(layoutInflater, binding.parentLinearLayout, false)
        initViews()
        setHasOptionsMenu(true)
//        getData()
        getShoes()
        return binding.root
    }


    private fun getShoes() {
        shoeViewModel.getShoesList().observe(requireActivity()) { listItem ->
            run {
                addViewToParentLayout(listItem)
            }
        }
    }

    private fun addViewToParentLayout(listItem: MutableList<Shoe>) {
        binding.parentLinearLayout.removeAllViews()
        listItem.forEach { item ->
            ticketShoeListBinding.shoe = item
            binding.parentLinearLayout.addView(
                ticketShoeListBinding.root
            )
        }
    }

    private fun initViews() {
        binding.addShoeFloatingBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.add_shoe_floating_btn -> {
                nextFragment()
            }
        }
    }


    private fun nextFragment() {
        findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToShoeDetailsFragment())
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu_item -> {
                findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToLoginFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


