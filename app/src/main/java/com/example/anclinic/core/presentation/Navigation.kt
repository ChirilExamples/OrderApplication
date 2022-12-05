package com.example.anclinic.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anclinic.oreder_feature.presentation.OrderChooseDelivererScreen
import com.example.anclinic.oreder_feature.presentation.OrderScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.OrderScreen.routes
    ) {
        composable(ScreenRoutes.OrderScreen.routes){
            OrderScreen(navController = navController)
        }
        composable(ScreenRoutes.OrderChooseDelivererScreen.routes){
            OrderChooseDelivererScreen(navController = navController)
        }
    }
}

sealed class ScreenRoutes(val routes: String) {
    object OrderScreen : ScreenRoutes("order_screen")
    object OrderChooseDelivererScreen : ScreenRoutes("order_choose_deliverer_screen")
    object OrderChooseProductsScreen : ScreenRoutes("order_choose_products_screen")
}