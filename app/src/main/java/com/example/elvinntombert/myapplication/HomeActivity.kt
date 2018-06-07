package com.example.elvinntombert.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val pagerAdapter = PageAdapter(supportFragmentManager, 4)

        homeViewPager.adapter = pagerAdapter

        mainTabLayout.setupWithViewPager(homeViewPager)


    }
}
