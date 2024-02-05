package com.example.viewmodeldivideexample.sampleFeature.di

import com.example.viewmodeldivideexample.sampleFeature.domain.IntUseCase
import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.AppViewModel
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.AppViewModelImpl
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.SharedUseCases
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

    @Singleton
    @Provides
    fun provideSharedUseCases(
        stringUseCase: StringUseCase,
        intUseCase: IntUseCase
    ): SharedUseCases {
        return SharedUseCases(
            stringUseCase = stringUseCase,
            intUseCase = intUseCase
        )
    }

    @Singleton
    @Provides
    fun provideIntUseCase(): IntUseCase {
        return IntUseCase()
    }
}