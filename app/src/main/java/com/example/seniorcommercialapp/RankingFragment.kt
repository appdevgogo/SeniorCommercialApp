package com.example.seniorcommercialapp

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RankingFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerNavigationView: NavigationView

    private lateinit var adapter: RankingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingList: List<RankingData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        callProductInfo()

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        //toolbar 세팅
        toolbar = view.findViewById(R.id.toolbar)
        toolbarTitle = toolbar.findViewById(R.id.toolbar_title)
        toolbarTitle.text = "롯데홈쇼핑"
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
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        return view
    }

    private fun callProductInfo(){

        val call = ApiObject.getProductInfo.getProductInfoAll(shopName = "lotte")
        call.enqueue(object: Callback<List<RankingData>> {

            override fun onResponse(call: Call<List<RankingData>>, response: Response<List<RankingData>>) {
                val tag = "OnResponse : "
                Log.d(tag, "호출 성공함")

                if(response.isSuccessful) {
                    rankingList = response.body() ?: listOf()
                    val tag = "ProductData : "
                    Log.d(tag, rankingList.toString())

                    getRankingList()


                }
            }

            override fun onFailure(call: Call<List<RankingData>>, t: Throwable) {

                val tag = "OnResponse : "
                Log.d(tag, "실패함")
            }
        })

    }

    private fun getRankingList(){

        adapter = RankingAdapter(rankingList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun reloadFragment(text: String) {

        toolbarTitle = toolbar.findViewById(R.id.toolbar_title)
        toolbarTitle.text = text
    }

}