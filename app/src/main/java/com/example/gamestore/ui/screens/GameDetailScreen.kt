package com.example.gamestore.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamestore.model.Game
import com.example.gamestore.model.PurchasableItem
import com.example.gamestore.ui.components.PurchasableItemCard

@Composable
fun GameDetailScreen(
    game: Game,
    onBackClick: () -> Unit, // Nova callback para voltar
    onItemClick: (PurchasableItem) -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Barra superior com seta de voltar, nome do jogo e coração
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Seta de voltar (à esquerda)
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                // Nome do jogo (centro)
                Text(
                    text = game.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.weight(1f),
                    // textAlign = TextAlign.Center
                )

                // Coração (à direita) - clicável mas sem ação
                IconButton(
                    onClick = { /* Não faz nada */ },
                    modifier = Modifier.size(48.dp),
                    enabled = true
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorito",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Imagem e descrição na mesma linha
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                // Imagem do jogo (lado esquerdo)
                Image(
                    painter = painterResource(id = game.imageResId),
                    contentDescription = game.name,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Descrição do jogo (lado direito)
                Text(
                    text = game.description,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Título da seção de itens compráveis
            Text(
                text = "Purchasable Items",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de itens compráveis
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                game.purchasableItems.forEach { item ->
                    PurchasableItemCard(
                        item = item,
                        onClick = { onItemClick(item) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun GameDetailScreenPreview() {
    MaterialTheme {
        GameDetailScreen(
            game = Game(
                id = 1,
                name = "Cyberpunk 2077",
                description = "Cyberpunk 2077 - RPG de ação em mundo aberto onde você é V, um mercenário em Night City que busca um implante único que concede imortalidade.",
                imageResId = android.R.drawable.ic_menu_gallery,
                purchasableItems = listOf(
                    PurchasableItem(
                        id = 1,
                        name = "Phantom Liberty",
                        description = "Expansão de espionagem com nova história, personagens e área para explorar.",
                        detailedDescription = "Descrição detalhada",
                        price = 29.99,
                        imageResId = android.R.drawable.ic_menu_gallery
                    )
                )
            ),
            onBackClick = {}, // Callback para voltar
            onItemClick = {}
        )
    }
}