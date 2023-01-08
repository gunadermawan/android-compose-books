package com.gunder.bookscompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import com.gunder.bookscompose.R
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gunder.bookscompose.ui.theme.BookscomposeTheme
import com.gunder.bookscompose.ui.theme.Shapes

@Composable
fun BookItem(
    image: Int,
    year: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(180.dp)
    ) {
        Column(
            modifier = modifier
                .padding(8.dp),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(Shapes.medium)
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReleaseDate(
                releaseDate = year,
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center
            )
            ButtonToDetail(
                modifier = Modifier.padding(8.dp),
                text = "Lihat Detail"
            )
        }
    }
}


@Composable
fun ReleaseDate(
    releaseDate: String,
    modifier: Modifier = Modifier,
) {
    Box {
        Card(
            modifier = modifier
                .width(44.dp)
                .height(22.dp)
        ) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(4.dp),
                text = releaseDate,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun ButtonToDetail(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color.Gray),
        modifier = modifier
            .padding(4.dp)
            .width(150.dp)
            .height(32.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
@Preview(showBackground = false)
fun RewardItemPreview() {
    BookscomposeTheme() {
        BookItem(R.drawable.books1, "2018", "The Atomic habits")
    }
}

@Composable
@Preview(showBackground = false)
fun ReleaseDatePreview() {
    BookscomposeTheme {
        ReleaseDate("2018")
    }
}

@Composable
@Preview(showBackground = false)
fun ButtonToDetailPreview() {
    BookscomposeTheme {
        ButtonToDetail("Lihat detail")
    }
}