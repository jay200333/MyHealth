package com.example.myhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhealth.databinding.FragmentOneBinding
import com.example.myhealth.databinding.FragmentThreeBinding

class FragmentThree: Fragment() {
    private lateinit var mBinding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentThreeBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}