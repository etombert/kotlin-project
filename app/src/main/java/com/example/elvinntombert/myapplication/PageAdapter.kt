package com.example.elvinntombert.myapplication

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PageAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment?{
        when (position) {
            0 -> return TabHome()
            1 -> return TabCalendar()
            2 -> return TabFavorie()
            3 -> return TabProfil()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}
