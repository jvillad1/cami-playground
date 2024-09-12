package com.cami.composeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cami.composeapp.ui.theme.CamiplaygroundTheme

@Composable
fun ProductScreen(modifier: Modifier = Modifier, productId: String) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = productId
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    CamiplaygroundTheme {
        ProductScreen(productId = "ABC")
    }
}
