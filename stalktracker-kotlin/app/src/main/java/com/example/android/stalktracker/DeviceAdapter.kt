package com.example.android.stalktracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeviceAdapter: RecyclerView.Adapter<Util.TextItemViewHolder>() {

    var data =  listOf<Device>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Util.TextItemViewHolder, position: Int) {
        val item=data[position]
        if(item.name.length>1)
            holder.textView.text =item.name
        else
            holder.textView.text=item.address
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Util.TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.device_found, parent, false) as TextView

        return Util.TextItemViewHolder(view)
    }


}