package com.example.gamestore.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings

@Composable
fun TopBar() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        // Barra nitificação e definições
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End /* Alinha para  direita */
        ) {
            // Notificações
            IconButton(
                onClick = {},
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificações",
                    //tint = Color.White
                    tint = Color.Black
                )
            }

            // Spacer(modifier = Modifier.width(0.dp))

            // Definições
            IconButton(
                onClick = { },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Definições",
                    //tint = Color.White
                    tint = Color.Black
                )
            }
        }

        // Nm empresa
        Text(
            text = "GAMES PARADE",
            fontSize = 24.sp,
            //color = Color.White,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    MaterialTheme {
        Surface(color = Color.White) {
            TopBar()
        }
    }
}