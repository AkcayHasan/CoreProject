package com.hasankcay.base.base_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    private var baseActivity: BaseActivity? = null

    private var _binding: VB? = null
    open val binding get() = _binding!!

    abstract fun getViewBinding(): VB

    protected val viewModel: VM by lazy { ViewModelProvider(this)[getViewModelClass()] }
    protected abstract fun getViewModelClass(): Class<VM>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseActivity = requireActivity() as BaseActivity
        _binding = getViewBinding()
        initUI(inflater, container, savedInstanceState)
        setOnClickItems()

        return binding.root
    }

    open fun setOnClickItems() {}

    open fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}