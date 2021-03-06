package com.example.androiddevchallenge.presentation.ui.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.Cat
import com.example.androiddevchallenge.presentation.ui.theme.MainTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CatItem(cat: Cat, onClick: () -> Unit) {
    val slash = cat.url.lastIndexOf('/')
    val description = cat.url.substring(slash + 1)

    Box(modifier = Modifier.padding(4.dp)) {
        Card(
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                CoilImage(
                    data = cat.url,
                    contentDescription = "Cat",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1f)
                )
                Column(Modifier.padding(10.dp)) {
                    Text(
                        text = cat.id,
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = description,
                        color = MaterialTheme.colors.secondaryVariant,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CatItemPreview() {
    MainTheme {
        Surface(color = MaterialTheme.colors.background) {
            val cat = Cat(id = "0 Fluffy", url = "https://developer.android.com/images/brand/Android_Robot.png")
            CatItem(cat) {}
        }
    }
}
