package com.example.myhealth

import android.annotation.TargetApi
import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.viewpager.widget.ViewPager
import com.example.myhealth.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

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
                0 -> {
                    tab.text = "훈련"
                    tab.setIcon(R.drawable.jihoon)
                }
                1 -> {
                    tab.text = "두번째 탭"
                    tab.setIcon(R.drawable.jihoon)
                }
                2 -> {
                    tab.text = "세번째 탭"
                    tab.setIcon(R.drawable.jihoon)
                }
            }
        }.attach()
    }
}

