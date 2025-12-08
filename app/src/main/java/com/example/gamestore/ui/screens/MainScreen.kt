package com.example.gamestore.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamestore.model.Game
import com.example.gamestore.ui.components.GameCard
import com.example.gamestore.ui.components.TopBar
import com.example.gamestore.ui.components.NavBar
import com.example.gamestore.ui.components.NavDestination

@Composable
fun MainScreen(
    games: List<Game>,
    onGameClick: (Game) -> Unit,
    currentRoute: String? = null,
    onNavigationItemSelected: (NavDestination) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            NavBar(
                currentRoute = currentRoute,
                onItemSelected = onNavigationItemSelected
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                //.background(Color.Black)
                .background(Color.White)
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(games) { game ->
                GameCard(
                    game = game,
                    onClick = { onGameClick(game) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            games = listOf(
                Game(
                    id = 1,
                    name = "Cyberpunk 2077",
                    description = "Descrição",
                    imageResId = android.R.drawable.ic_menu_gallery,
                    purchasableItems = emptyList()
                ),
                Game(
                    id = 2,
                    name = "The Witcher 3",
                    description = "Descrição",
                    imageResId = android.R.drawable.ic_menu_gallery,
                    purchasableItems = emptyList()
                )
            ),
            onGameClick = {}
        )
    }
}