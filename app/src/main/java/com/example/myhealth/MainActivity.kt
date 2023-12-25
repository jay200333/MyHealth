package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.myhealth.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setViewPagerInit()
        setTabInit()
    }

    private fun setViewPagerInit() {
        val fragmentList = listOf(
            FragmentOne(),
            FragmentTwo(),
            FragmentThree()
        )
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.fragments.addAll(fragmentList)
        mBinding.viewPager.adapter = viewPagerAdapter
    }
    private fun setTabInit() {
        TabLayoutMediator(mBinding.bottomTabs, mBinding.viewPager) { tab, pos ->
            tab.text = pos.toString()
            when (pos) {
                0 -> tab.text = "첫번째 탭"
                1 -> tab.text = "두번째 탭"
                2 -> tab.text = "세번째 탭"
            }
        }.attach()
    }
}

