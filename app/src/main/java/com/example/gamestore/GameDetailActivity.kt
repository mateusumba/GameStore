package com.example.gamestore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.gamestore.model.Game
import com.example.gamestore.model.PurchasableItem
import com.example.gamestore.ui.components.BottomSheetContent
import com.example.gamestore.ui.screens.GameDetailScreen
import com.example.gamestore.ui.theme.GameStoreTheme

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = intent.getParcelableExtra<Game>("GAME")
            ?: throw IllegalArgumentException("Game não encontrado no intent")

        setContent {
            GameStoreTheme {
                val context = LocalContext.current
                var showBottomSheet by remember { mutableStateOf(false) }
                var selectedItem by remember { mutableStateOf<PurchasableItem?>(null) }

                // Abordagem alternativa com BottomSheetDialog
                if (showBottomSheet && selectedItem != null) {
                    AlertDialog(
                        onDismissRequest = {
                            showBottomSheet = false
                            selectedItem = null
                        },
                        title = { Text(selectedItem!!.name) },
                        text = {
                            // Conteúdo customizado
                            BottomSheetContent(
                                item = selectedItem!!,
                                onBuyClick = {
                                    showBottomSheet = false
                                    Toast.makeText(
                                        context,
                                        "Acabou de comprar o ${selectedItem!!.name} por $${String.format("%.2f", selectedItem!!.price)}",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    selectedItem = null
                                }
                            )
                        },
                        confirmButton = {},
                        dismissButton = {}
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameDetailScreen(
                        game = game,
                        onBackClick = {
                            // Fecha esta Activity e volta para a MainActivity
                            finish()
                        },
                        onItemClick = { item ->
                            selectedItem = item
                            showBottomSheet = true
                        }
                    )
                }
            }
        }
    }
}