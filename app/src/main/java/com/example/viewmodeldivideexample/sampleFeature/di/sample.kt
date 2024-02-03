package com.example.viewmodeldivideexample.sampleFeature.di

import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SampleModule {

    @Singleton
    @Provides
    fun provideStringUseCase(): StringUseCase {
        return StringUseCase()
    }
}