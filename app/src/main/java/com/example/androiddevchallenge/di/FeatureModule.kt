package com.example.androiddevchallenge.di

import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.presentation.viewmodel.MainViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface FeatureModule {

    @Binds
    fun viewModel(vm: MainViewModelFactory): ViewModelProvider.Factory
}
