package com.hasankcay.coreproject.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hasankcay.base.base_ui.BaseFragment
import com.hasankcay.coreproject.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<ProfileVM, FragmentProfileBinding>() {
    override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)
    override fun getViewModelClass(): Class<ProfileVM> = ProfileVM::class.java

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {

    }

    override fun setOnClickItems() {

    }


}