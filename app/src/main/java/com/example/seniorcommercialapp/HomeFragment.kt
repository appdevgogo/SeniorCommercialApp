package com.example.seniorcommercialapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeList: List<HomeData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHomeList()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HomeAdapter(homeList)
        recyclerView.adapter = adapter

    }


    private fun initHomeList(){

        homeList = listOf(
            HomeData(img = R.drawable.p_img_01, title = getString(R.string.ranking_name_1), price = getString(R.string.ranking_price_1)),
            HomeData(img = R.drawable.p_img_02, title = getString(R.string.ranking_name_2), price = getString(R.string.ranking_price_2)),
            HomeData(img = R.drawable.p_img_03, title = getString(R.string.ranking_name_3), price = getString(R.string.ranking_price_3))
        )

    }
}