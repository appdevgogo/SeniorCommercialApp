package com.example.seniorcommercialapp

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.drawerlayout.widget.DrawerLayout

class RankingFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var adapter: RankingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingArrayList: ArrayList<RankingData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        //toolbar 세팅
        toolbar = view.findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_drawer_normal) //toolbar의 왼쪽 메뉴 아이콘 버튼
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        //drawer 세팅
        drawerLayout = view.findViewById(R.id.ranking_drawer_layout)

        //ranking list 세팅
        getRankingList()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RankingAdapter(rankingArrayList)
        recyclerView.adapter = adapter


        return view
    }


    private fun getRankingList(){

        rankingArrayList = arrayListOf(
            RankingData(img = R.drawable.p_img_01, name = getString(R.string.name_1), price = getString(R.string.price_1)),
            RankingData(img = R.drawable.p_img_02, name = getString(R.string.name_2), price = getString(R.string.price_2)),
            RankingData(img = R.drawable.p_img_03, name = getString(R.string.name_3), price = getString(R.string.price_3))
        )

    }

}