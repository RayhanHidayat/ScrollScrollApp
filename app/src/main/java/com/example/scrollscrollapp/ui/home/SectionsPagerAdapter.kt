package com.example.scrollscrollapp.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.scrollscrollapp.R
import com.example.scrollscrollapp.ui.pageone.PageOneFragment
import com.example.scrollscrollapp.ui.pagetwo.PageTwoFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager):FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(R.string.pagone,R.string.pagetwo)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> PageOneFragment()
            1 -> PageTwoFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLE[position])

}