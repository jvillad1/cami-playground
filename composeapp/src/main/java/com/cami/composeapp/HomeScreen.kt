package com.cami.composeapp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cami.composeapp.ui.theme.CamiplaygroundTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onProductClick: (String) -> Unit) {
    val scope = rememberCoroutineScope()

    var isButtonClicked by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                isButtonClicked = true

                scope.launch {
                    delay(2000)
                    onProductClick("ABC")
                }
            }
        ) {
            Text(
                text = "ABC"
            )
        }

        if (isButtonClicked) {
            Text(
                text = "Clicked"
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
