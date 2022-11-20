package com.example.seniorcommercialapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HomeAdapter(private val homeList: List<HomeData>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ranking_list_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = homeList[position]
        holder.img.setImageResource(currentItem.img)
        holder.title.text = currentItem.title
        holder.price.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img: ImageView = itemView.findViewById(R.id.ranking_p_photo)
        val title: TextView = itemView.findViewById(R.id.ranking_p_name)
        val price: TextView = itemView.findViewById(R.id.ranking_p_price)

    }

}

