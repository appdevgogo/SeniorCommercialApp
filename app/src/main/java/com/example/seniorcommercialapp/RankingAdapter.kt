package com.example.seniorcommercialapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RankingAdapter(private val rankingList: ArrayList<RankingData>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ranking_list_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rankingList[position]
        holder.imgRanking.setImageResource(currentItem.img)
        holder.txtName.text = currentItem.name
        holder.txtPrice.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return rankingList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgRanking: ImageView = itemView.findViewById(R.id.ranking_p_photo)
        val txtName: TextView = itemView.findViewById(R.id.ranking_p_name)
        val txtPrice: TextView = itemView.findViewById(R.id.ranking_p_price)

    }

}

