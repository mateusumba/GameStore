package com.example.gamestore

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.gamestore.data.SampleData
import com.example.gamestore.ui.screens.MainScreen
import com.example.gamestore.ui.theme.GameStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameStoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        games = SampleData.games,
                        onGameClick = { game ->
                            val intent = Intent(this@MainActivity, GameDetailActivity::class.java)
                            intent.putExtra("GAME", game)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}