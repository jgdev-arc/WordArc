package com.tlz.wordarc.domain.repo

import com.tlz.wordarc.domain.model.WordItem
import com.tlz.wordarc.util.Result
import kotlinx.coroutines.flow.Flow

interface WordRepo {
    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>
}