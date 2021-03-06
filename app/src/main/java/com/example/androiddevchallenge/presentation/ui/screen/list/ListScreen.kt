package com.example.androiddevchallenge.presentation.ui.screen.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.domain.Cat
import com.example.androiddevchallenge.presentation.ui.theme.MainTheme

@Composable
fun ListScreen(
    navController: NavController,
    catsData: LiveData<List<Cat>>,
    setTitle: (String) -> Unit
) {
    val cats: List<Cat> by catsData.observeAsState(emptyList())
    setTitle("Puppy Adoption")
    CatList(cats) {
        navController.navigate("details/${it.id}")
    }
}

@Composable
fun CatList(cats: List<Cat>, onClick: (Cat) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(cats, key = { it.id }) {
            CatItem(cat = it, onClick = { onClick(it) })
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatListPreview() {
    MainTheme {
        Surface(color = MaterialTheme.colors.background) {
            val cats = listOf(
                Cat(id = "0 Fluffy", url = "https://developer.android.com/images/brand/Android_Robot.png"),
                Cat(id = "1 Kinder", url = "https://developer.android.com/images/brand/Android_Robot.png"),
                Cat(id = "2 Zoika", url = "https://developer.android.com/images/brand/Android_Robot.png"),
                Cat(id = "3 Melody", url = "https://developer.android.com/images/brand/Android_Robot.png"),
                Cat(id = "4 Vasya", url = "https://developer.android.com/images/brand/Android_Robot.png")
            )
            CatList(cats) {}
        }
    }
}
