package com.example.seniorcommercialapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var adapter: RankingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingArrayList: ArrayList<RankingData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRankingList()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RankingAdapter(rankingArrayList)
        recyclerView.adapter = adapter

    }

    private fun initRankingList(){

        rankingArrayList = arrayListOf(
            RankingData(img = R.drawable.p_img_01, name = getString(R.string.name_1), price = getString(R.string.price_1)),
            RankingData(img = R.drawable.p_img_02, name = getString(R.string.name_2), price = getString(R.string.price_2)),
            RankingData(img = R.drawable.p_img_03, name = getString(R.string.name_3), price = getString(R.string.price_3))
        )

    }
}