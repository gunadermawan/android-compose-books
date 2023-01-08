package com.gunder.bookscompose.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gunder.bookscompose.R
import com.gunder.bookscompose.ui.components.ProfileItem
import com.gunder.bookscompose.ui.theme.BookscomposeTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    androidx.compose.material3.Card {
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navigateBack() }
            )
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .padding(16.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.gunadermawan),
                contentScale = ContentScale.FillWidth,
                contentDescription = "user profile"
            )
            Spacer(modifier = modifier.height(8.dp))
            ProfileItem(title = "Name", field = "Guna Dermawan")
            ProfileItem(title = "Email", field = "gunadermawan62@gmail.com")
            ProfileItem(title = "Kota", field = "Semarang")
        }
    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BookscomposeTheme() {
        ProfileScreen(navigateBack = {})
    }
}