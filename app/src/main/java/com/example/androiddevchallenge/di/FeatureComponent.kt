package com.example.androiddevchallenge.di

import com.example.androiddevchallenge.presentation.MainActivity
import dagger.Component

@Component(modules = [FeatureModule::class, NetworkModule::class])
interface FeatureComponent {

    fun inject(target: MainActivity)
}
