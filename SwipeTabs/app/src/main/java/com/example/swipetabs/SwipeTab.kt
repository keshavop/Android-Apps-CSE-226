package com.example.swipetabs

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class SwipeTab : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var viewPagerAdapter: ViewPageAdapter? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_tab)
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)
        viewPagerAdapter = ViewPageAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager)
    }
}