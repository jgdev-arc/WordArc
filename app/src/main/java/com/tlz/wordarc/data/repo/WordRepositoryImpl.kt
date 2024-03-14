package com.tlz.wordarc.data.repo

import android.app.Application
import android.net.http.HttpException
import com.tlz.wordarc.R
import com.tlz.wordarc.data.api.WordApi
import com.tlz.wordarc.data.mapper.toWordItem
import com.tlz.wordarc.domain.model.WordItem
import com.tlz.wordarc.domain.repo.WordRepo
import com.tlz.wordarc.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
    private val wordApi: WordApi,
    private val application: Application
): WordRepo {
    override suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWordResultDto = try {
                wordApi.getWordResult(word)
            } catch (e: retrofit2.HttpException) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.result_invalid)))
                emit(Result.Loading(false))
                return@flow
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.result_invalid)))
                emit(Result.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.result_invalid)))
                emit(Result.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let {wordResultDto ->
                wordResultDto[0]?.let {wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow
                }
            }

            emit(Result.Loading(false))
        }
    }

}