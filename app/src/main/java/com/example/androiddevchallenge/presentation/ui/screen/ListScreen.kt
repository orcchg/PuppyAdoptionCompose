package com.example.androiddevchallenge.presentation.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.example.androiddevchallenge.domain.Cat

@Composable
fun ListScreen(catsData: LiveData<List<Cat>>) {
    val cats: List<Cat> by catsData.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Puppy Adoption")
                }
            )
        }
    ) {
        CatList(cats) {}
    }
}
