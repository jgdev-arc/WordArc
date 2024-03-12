package com.tlz.wordarc.data.dto

data class WordItemDto(
    val meanings: List<MeaningDto>? = null,
    val phonetic: String,
    val word: String? = null
)