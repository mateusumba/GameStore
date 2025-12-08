package com.example.gamestore.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

// Enum para representar os destinos de navegação
enum class NavDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    FEATURED(
        route = "featured",
        label = "Featured",
        icon = Icons.Default.Star,
        contentDescription = "ir para inicial"
    ),
    HISTORY(
        route = "history",
        label = "History",
        icon = Icons.Default.ShoppingCart,
        contentDescription = "ir para History" // Prof houve dificuldade para achar achar o icon do history
    ),
    PROFILE(
        route = "profile",
        label = "Perfil",
        icon = Icons.Default.AccountCircle,
        contentDescription = "ir para Usuário"
    )
}

@Composable
fun NavBar(
    currentRoute: String? = null,
    onItemSelected: (NavDestination) -> Unit
) {
    // Determina o índice baseado na rota atual
    val initialSelectedIndex = currentRoute?.let { route ->
        NavDestination.entries.indexOfFirst { it.route == route }
    } ?: NavDestination.FEATURED.ordinal

    // Estado para controlar qual item está selecionado
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(initialSelectedIndex)
    }

    NavigationBar(
        containerColor = Color.White,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        NavDestination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onItemSelected(destination)
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.contentDescription
                    )
                },
                label = {
                    Text(
                        text = destination.label,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NavBarNoRouteSelectedPreview() {
    MaterialTheme {
        Surface {
            NavBar(
                currentRoute = null,
                onItemSelected = { destination ->
                }
            )
        }
    }
}

