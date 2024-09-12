package com.cami.composeapp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cami.composeapp.ui.theme.CamiplaygroundTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onProductClick: (String) -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onProductClick("ABC") }
        ) {
            Text(
                text = "ABC"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CamiplaygroundTheme {
        HomeScreen { id ->
            Log.d("Preview", "Hola $id")
        }
    }
}
