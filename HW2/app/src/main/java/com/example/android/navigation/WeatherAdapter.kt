package com.example.android.navigation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.ua.nextweather.datamodel.CallResponse

class WeatherAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data =  listOf<CallResponse.Weather>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.forecastDate.toString()+" - Entre "+item.tMin.toString()+" e "+item.tMax.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.item, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}