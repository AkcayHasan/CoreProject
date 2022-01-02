package com.hasankcay.base.base_navigation

import androidx.navigation.NavDirections
import com.hasankcay.base.base_utils.PopupListener
import com.hasankcay.base.base_utils.PopupModel

sealed class NavigationCommand {
    data class ToDirection(val directions: NavDirections) : NavigationCommand()
    data class ToDeepLink(val deepLink: String) : NavigationCommand()
    data class Popup(val model: PopupModel, val listener: PopupListener? = null) :
        NavigationCommand()

    object Back : NavigationCommand()
}
