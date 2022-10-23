package com.example.seniorcommercialapp

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class RankingFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbar_title: TextView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerNavigationView: NavigationView

    private lateinit var adapter: RankingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingArrayList: ArrayList<RankingData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        //toolbar 세팅
        toolbar = view.findViewById(R.id.toolbar)
        toolbar_title = toolbar.findViewById(R.id.toolbar_title)
        toolbar_title.text = "롯데홈쇼핑"
        toolbar.setNavigationIcon(R.drawable.ic_drawer_normal) //toolbar의 왼쪽 메뉴 아이콘 버튼
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }


        //drawer 세팅
        drawerLayout = view.findViewById(R.id.ranking_drawer_layout)
        drawerNavigationView = drawerLayout.findViewById(R.id.ranking_drawer_nav_view)
        drawerNavigationView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.menu_drawer_item1 -> reloadFragment("롯데홈쇼핑")
                R.id.menu_drawer_item2 -> reloadFragment("현대홈쇼핑")
                R.id.menu_drawer_item3 -> reloadFragment("NH홈쇼핑")
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

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

    private fun reloadFragment(text: String) {

        toolbar_title = toolbar.findViewById(R.id.toolbar_title)
        toolbar_title.text = text
    }

}