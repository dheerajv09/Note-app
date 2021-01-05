package com.example.noteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.example.noteapplication.adapter.BottomNavigationBarPageViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var homeBtn: ImageButton
    private lateinit var addBtn:ImageButton
    private lateinit var notiBtn:ImageButton
    private lateinit var searchBtn:ImageButton
    private lateinit var profileBtn:ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapterBottomNavigationBar: BottomNavigationBarPageViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // init views
        mViewPager = findViewById(R.id.mViewPager)
        homeBtn = findViewById(R.id.homeBtn)
        addBtn = findViewById(R.id.addBtn)
        profileBtn = findViewById(R.id.profileBtn)
        searchBtn = findViewById(R.id.searchBtn)
        notiBtn = findViewById(R.id.notiBtn)


        //onclick listner

        homeBtn.setOnClickListener {
            mViewPager.currentItem = 0

        }

        searchBtn.setOnClickListener {

            mViewPager.currentItem = 1

        }

        addBtn.setOnClickListener {
            mViewPager.currentItem = 2

        }

        notiBtn.setOnClickListener {
            mViewPager.currentItem = 3

        }

        profileBtn.setOnClickListener {
            mViewPager.currentItem = 4

        }




        mPagerViewAdapterBottomNavigationBar = BottomNavigationBarPageViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerViewAdapterBottomNavigationBar
        mViewPager.offscreenPageLimit = 5



        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changeTabs(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })




        mViewPager.currentItem = 0
        homeBtn.setImageResource(R.drawable.ic_home)



    }

    private fun changeTabs(position: Int) {


        if (position == 0) {
            homeBtn.setImageResource(R.drawable.ic_home)
            searchBtn.setImageResource(R.drawable.ic_archive)
            addBtn.setImageResource(R.drawable.ic_add)
            notiBtn.setImageResource(R.drawable.ic_delete)
            profileBtn.setImageResource(R.drawable.ic_settings)

        }
        if (position == 1) {
            homeBtn.setImageResource(R.drawable.ic_home)
            searchBtn.setImageResource(R.drawable.ic_archive)
            addBtn.setImageResource(R.drawable.ic_add)
            notiBtn.setImageResource(R.drawable.ic_delete)
            profileBtn.setImageResource(R.drawable.ic_settings)

        }
        if (position == 2) {
            homeBtn.setImageResource(R.drawable.ic_home)
            searchBtn.setImageResource(R.drawable.ic_archive)
            addBtn.setImageResource(R.drawable.ic_add)
            notiBtn.setImageResource(R.drawable.ic_delete)
            profileBtn.setImageResource(R.drawable.ic_settings)

        }
        if (position == 3) {
            homeBtn.setImageResource(R.drawable.ic_home)
            searchBtn.setImageResource(R.drawable.ic_archive)
            addBtn.setImageResource(R.drawable.ic_add)
            notiBtn.setImageResource(R.drawable.ic_delete)
            profileBtn.setImageResource(R.drawable.ic_settings)

        }
        if (position == 4) {
            homeBtn.setImageResource(R.drawable.ic_home)
            searchBtn.setImageResource(R.drawable.ic_archive)
            addBtn.setImageResource(R.drawable.ic_add)
            notiBtn.setImageResource(R.drawable.ic_delete)
            profileBtn.setImageResource(R.drawable.ic_settings)

        }

    }

}