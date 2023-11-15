package com.example.swipetabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm)
{
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0)
            fragment = fragment1()
        else if (position == 1)
            fragment = fragment2()
        else if (position == 2)
            fragment = fragment3()
        return fragment!!
    }
    override fun getCount(): Int {
        return 3
    }
    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0)
            title = "CSE1"
        else if (position == 1)
            title = "CSE2"
        else if (position == 2)
            title = "CSE3"
        return title
    }
}