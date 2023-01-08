package com.gunder.bookscompose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gunder.bookscompose.ui.navigation.ScreenBook
import com.gunder.bookscompose.ui.screen.detail.DetailScreen
import com.gunder.bookscompose.ui.screen.home.HomeScreen
import com.gunder.bookscompose.ui.screen.profile.ProfileScreen
import com.gunder.bookscompose.ui.theme.BookscomposeTheme

@Composable
fun MyBooks(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(topBar = {
        if (currentRoute == ScreenBook.Home.route) {
            TopBar(navController = navController, modifier = modifier.padding(start = 8.dp))
        }
    },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = ScreenBook.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(ScreenBook.Home.route) {
                    HomeScreen(navigateToDetail = { booksId ->
                        navController.navigate(ScreenBook.DetailBook.createRoute(booksId))
                    })
                }
                composable(ScreenBook.Profile.route) {
                    ProfileScreen(navigateBack = { navController.navigateUp() })
                }
                composable(
                    route = ScreenBook.DetailBook.route,
                    arguments = listOf(navArgument("bookId") { type = NavType.LongType })
                ) {
                    val id = it.arguments?.getLong("bookId") ?: -1L
                    DetailScreen(phoneId = id, navigateBack = { navController.navigateUp() })
                }
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    navController: NavHostController,
    modifier: Modifier,
) {
    CenterAlignedTopAppBar(title = {
    }, actions = {
        IconButton(onClick = {
            navController.navigate(ScreenBook.Profile.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "about_page",
                modifier = modifier.size(32.dp),
                tint = Color.Black
            )
        }
    })
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    BookscomposeTheme {
        MyBooks()
    }
}