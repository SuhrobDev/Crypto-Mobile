package dev.soul.mycomposeexp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.soul.mycomposeexp.navigation.AppNavigation
import dev.soul.mycomposeexp.navigation.BottomNav
import dev.soul.mycomposeexp.navigation.Screens

@Composable
fun MainScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        Screens.Confirm.route+"/{amountValue}" -> false
        Screens.Finish.route -> false
        Screens.Transaction.route -> false
        else -> true
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            title = when (backStackEntry.destination.route) {
                Screens.Transaction.route -> Screens.Transaction.title.toString()
                else -> ""
            }
        }
    }

    Scaffold(
        bottomBar = { if (showBottomBar) BottomNav(navController = navController) },
        content = {
            Box(modifier = Modifier.padding(it)) {
                AppNavigation(navController = navController)
            }
        },
    )

}