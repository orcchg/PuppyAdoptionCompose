package com.example.androiddevchallenge.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androiddevchallenge.data.Rest
import com.example.androiddevchallenge.domain.Cat
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val rest: Rest) : ViewModel() {

    val cats: LiveData<List<Cat>> = liveData {
        try {
            val data = rest.cats()
            emit(data)
        } catch (e: Throwable) {
            Timber.e(e)
        }
    }
}
