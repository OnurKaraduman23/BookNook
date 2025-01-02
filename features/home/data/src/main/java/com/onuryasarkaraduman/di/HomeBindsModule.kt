package com.onuryasarkaraduman.di

import com.onuryasarkaraduman.repository.HomeRepository
import com.onuryasarkaraduman.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class HomeBindsModule {

    @Binds
    @ViewModelScoped
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}