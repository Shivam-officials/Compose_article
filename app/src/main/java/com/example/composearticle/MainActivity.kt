package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleApp()
                }
            }
        }
    }
}


/*
 * composable funtion for calling the ArticleCard
 */
@Composable
fun ArticleApp() {
    ArticleCard(
        title = stringResource(id = R.string.title),
        imagePainter = painterResource(id = R.drawable.bg_compose_background),
        shortDesc = stringResource(id = R.string.compose_short_desc),
        longDesc = stringResource(id = R.string.compose_long_desc)
    )
}

//articleCard Compose for Article Structure
@Composable
fun ArticleCard(
    title: String,
    imagePainter: Painter,
    shortDesc: String,
    longDesc: String,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )

        Text(
            text = shortDesc,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
        )

        Text(
            text = longDesc,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun HomepagePreview() {
    ArticleApp()

}