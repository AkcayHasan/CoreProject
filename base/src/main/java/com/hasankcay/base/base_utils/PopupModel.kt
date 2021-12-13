package com.hasankcay.base.base_utils

data class PopupModel(
    var title: String? = null,
    var message: String? = null,
    var cancelable: Boolean = false,
    var positiveButtonText: String? = null,
    var negativeButtonText: String? = null
)
