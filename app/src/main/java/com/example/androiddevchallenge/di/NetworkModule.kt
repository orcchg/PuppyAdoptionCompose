package com.example.androiddevchallenge.di

import com.example.androiddevchallenge.data.Rest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [CloudModule::class])
object NetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): Rest = retrofit.create()
}
