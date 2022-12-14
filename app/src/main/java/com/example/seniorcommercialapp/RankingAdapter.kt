package com.example.seniorcommercialapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RankingAdapter(private val rankingList: List<RankingData>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ranking_list_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rankingList[position]

        Glide.with(holder.itemView.context)
            .load(currentItem.pimgurl) // 불러올 이미지 url
            .into(holder.img) // 이미지를 넣을 뷰

        holder.title.text = currentItem.ptitle
        holder.price.text = currentItem.pprice

    }

    override fun getItemCount(): Int {
        return rankingList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img: ImageView = itemView.findViewById(R.id.ranking_p_photo)
        val title: TextView = itemView.findViewById(R.id.ranking_p_name)
        val price: TextView = itemView.findViewById(R.id.ranking_p_price)

    }

}

