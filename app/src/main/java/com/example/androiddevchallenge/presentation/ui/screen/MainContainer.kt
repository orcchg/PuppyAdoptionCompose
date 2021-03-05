package com.example.androiddevchallenge.presentation.ui.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.presentation.ui.theme.MainTheme

@Composable
fun MainContainer(content: @Composable () -> Unit) {
    MainTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
