package com.cami.composeapp.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.cami.composeapp.features.home.HomeScreen
import com.cami.composeapp.features.product.ProductScreen

@Composable
fun NavGraph() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            composable<HomeRoute> {
                HomeScreen(
                    modifier = modifier,
                    onProductClick = { id ->
                        navController.navigate(route = ProductRoute(id))
                    }
                )
            }

            composable<ProductRoute> { backStackEntry ->
                val product: ProductRoute = backStackEntry.toRoute()

                ProductScreen(
                    modifier = modifier,
                    productId = product.productId
                )
            }
        }
    }
}
