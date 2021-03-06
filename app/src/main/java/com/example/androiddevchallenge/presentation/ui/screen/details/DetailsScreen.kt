package com.example.androiddevchallenge.presentation.ui.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.androiddevchallenge.domain.Cat
import com.example.androiddevchallenge.presentation.ui.theme.MainTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailsScreen(
    catsData: LiveData<List<Cat>>,
    id: String,
    setTitle: (String) -> Unit
) {
    val cats: List<Cat> by catsData.observeAsState(emptyList())
    cats.find { it.id == id }?.let {
        setTitle("Puppy: ${it.id}")
        CatDetails(cat = it)
    }
}

@Composable
fun CatDetails(cat: Cat) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CoilImage(
            data = cat.url,
            contentDescription = "Cat",
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = cat.id,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview
@Composable
fun CatDetailsPreview() {
    MainTheme {
        Surface(color = MaterialTheme.colors.background) {
            CatDetails(cat = Cat(id = "0 Fluffy", url = "https://developer.android.com/images/brand/Android_Robot.png"))
        }
    }
}
