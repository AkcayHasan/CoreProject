package com.hasankcay.base.base_ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.hasankcay.base.base_navigation.NavigationCommand
import com.hasankcay.base.base_network.Failure
import com.hasankcay.base.base_utils.PopupListener
import com.hasankcay.base.base_utils.PopupModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BaseViewModel : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    private val _navigation = MutableStateFlow<NavigationCommand>(NavigationCommand.Default)
    val navigation: StateFlow<NavigationCommand> = _navigation

    private val _popup = MutableStateFlow(PopupModel())
    val popup: StateFlow<PopupModel> = _popup

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