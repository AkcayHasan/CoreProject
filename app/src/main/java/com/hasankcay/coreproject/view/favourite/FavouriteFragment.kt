package com.hasankcay.coreproject.view.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hasankcay.base.base_ui.BaseFragment
import com.hasankcay.coreproject.databinding.FragmentFavouriteBinding

class FavouriteFragment : BaseFragment<FavouriteVM, FragmentFavouriteBinding>() {
    override fun getViewBinding(): FragmentFavouriteBinding = FragmentFavouriteBinding.inflate(layoutInflater)
    override fun getViewModelClass(): Class<FavouriteVM> = FavouriteVM::class.java

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {

    }

    override fun setOnClickItems() {

    }

}