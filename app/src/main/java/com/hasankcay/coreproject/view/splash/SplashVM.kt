package com.hasankcay.coreproject.view.splash

import com.hasankcay.base.base_ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    private val useCase: SplashUseCase
): BaseViewModel() {


}