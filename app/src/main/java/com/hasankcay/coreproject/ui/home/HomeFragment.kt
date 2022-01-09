package com.hasankcay.coreproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hasankcay.base.base_ui.BaseFragment
import com.hasankcay.coreproject.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeVM, FragmentHomeBinding>() {
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
    override fun getViewModelClass(): Class<HomeVM> = HomeVM::class.java

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {

    }

    override fun setOnClickItems() {

    }


}