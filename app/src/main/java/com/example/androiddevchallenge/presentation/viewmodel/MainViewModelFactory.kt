package com.example.androiddevchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class MainViewModelFactory @Inject constructor(
    private val provider: Provider<MainViewModel>
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = provider.get() as T
}
