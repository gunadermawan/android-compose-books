package com.gunder.bookscompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gunder.bookscompose.ui.theme.BookscomposeTheme

@Composable
fun ProfileItem(
    title: String,
    field: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.padding(all = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            modifier = modifier.padding(bottom = 2.dp),
            text = field,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileItemReview() {
    BookscomposeTheme() {
        ProfileItem(title = "Email", field = "gunader@gmail.com")
    }
}