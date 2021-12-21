package com.hasankcay.base.base_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.hasankcay.base.base_navigation.NavigationCommand
import com.hasankcay.base.base_network.Failure
import com.hasankcay.base.base_network.SingleLiveEvent
import com.hasankcay.base.base_utils.PopupListener
import com.hasankcay.base.base_utils.PopupModel

class BaseViewModel : ViewModel() {

    private val _loading = SingleLiveEvent<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    private val _navigation = SingleLiveEvent<NavigationCommand>()
    val navigation: LiveData<NavigationCommand> = _navigation

    private val _popup = SingleLiveEvent<PopupModel>()
    val popup: LiveData<PopupModel> = _popup

    fun handleFailure(failure: Failure) {
        val message = when(failure) {
            is Failure.NoConnectivityError -> "No Internet Connection"
            is Failure.ApiError -> failure.message
            is Failure.UnknownError ->
                failure.exception.localizedMessage
                    ?: "An Error Occured!"
            is Failure.TimeOutError -> "Request Timed Out"
            else -> failure.message ?: failure.toString()
        }
        _popup.value = PopupModel(message = message)
    }

    fun navigate(direction: NavDirections) {
        _navigation.value = NavigationCommand.ToDirection(direction)
    }

    fun navigate(deepLink: String) {
        _navigation.value = NavigationCommand.ToDeepLink(deepLink)
    }

    fun navigate(model: PopupModel, listener: PopupListener?) {
        _navigation.value = NavigationCommand.Popup(model, listener)
    }

    fun showLoading() {
        _loading.value = true
    }

    fun hideLoading() {
        _loading.value = false
    }

}