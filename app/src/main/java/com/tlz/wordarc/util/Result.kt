package com.tlz.wordarc.util

import kotlin.Result

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?): com.tlz.wordarc.util.Result<T>(data)

    class Error<T>(message: String): com.tlz.wordarc.util.Result<T>(null, message)

    class Loading<T>(val isLoading: Boolean = true): com.tlz.wordarc.util.Result<T>(null)
}
