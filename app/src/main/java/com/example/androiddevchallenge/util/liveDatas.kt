package com.example.androiddevchallenge.util

import androidx.activity.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any, L : LiveData<T>> ComponentActivity.observe(liveData: L, body: (T) -> Unit = {}) =
    liveData.observe(this, Observer(body))
