/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.di.DaggerFeatureComponent
import com.example.androiddevchallenge.presentation.ui.screen.ListScreen
import com.example.androiddevchallenge.presentation.ui.theme.MainTheme
import com.example.androiddevchallenge.presentation.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFeatureComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                ListScreen(viewModel.cats)
            }
        }
    }
}
