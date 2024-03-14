package com.tlz.wordarc.di

import com.tlz.wordarc.data.repo.WordRepositoryImpl
import com.tlz.wordarc.domain.repo.WordRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindWordRepo(
        wordRepositoryImpl: WordRepositoryImpl
    ): WordRepo


}