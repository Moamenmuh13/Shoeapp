package com.mundroid.apps.shoeapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mundroid.apps.shoeapp.R
import com.mundroid.apps.shoeapp.databinding.TicketShoeListBinding
import com.mundroid.apps.shoeapp.models.Shoe

class ShoeAdapter(private val context: Context, private val shoeArrayList: ArrayList<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: TicketShoeListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: TicketShoeListBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.ticket_shoe_list, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = shoeArrayList[position]
        with(holder) {
            with(item) {
                holder.binding.shoeSize.text = item.shoeSize.toString()
                holder.binding.companyName.text = item.companyName
                holder.binding.shoeName.text = item.shoeName
                holder.binding.description.text = item.description
            }
        }
    }

    override fun getItemCount(): Int = shoeArrayList.size
}