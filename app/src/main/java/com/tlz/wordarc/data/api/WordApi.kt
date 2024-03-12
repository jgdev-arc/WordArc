package com.tlz.wordarc.data.api

import com.tlz.wordarc.data.dto.WordResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WordApi {

    @GET("{word}")
    suspend fun getWordResult(
        @Path("word") word: String
    ): WordResultDto

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/hello"
    }


}