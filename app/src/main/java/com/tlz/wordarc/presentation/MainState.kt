package com.tlz.wordarc.presentation

import com.tlz.wordarc.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? = null
)
