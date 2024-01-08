package dev.soul.mycomposeexp.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.soul.mycomposeexp.R
import dev.soul.mycomposeexp.screens.finish.FinishScreen
import dev.soul.mycomposeexp.screens.home.HomeScreen
import dev.soul.mycomposeexp.screens.page2.Page2Screen
import dev.soul.mycomposeexp.screens.page3.Page3Screen
import dev.soul.mycomposeexp.screens.page4.Page4Screen
import dev.soul.mycomposeexp.screens.transaction.TransactionScreen
import dev.soul.mycomposeexp.screens.transaction.confirm.ConfirmScreen
import dev.soul.mycomposeexp.ui.theme.Primary


@Composable
fun AppNavigation(
    navController: NavHostController
) {

    val screenBackground = Primary
    NavHost(
        modifier = Modifier.background(screenBackground),
        navController = navController,
        startDestination = Screens.Home.route
    ) {

        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.Wallet.route,
        ) {
            Page2Screen(navController = navController)
        }

        composable(
            route = Screens.Cole.route,
        ) {
            Page3Screen(navController = navController)
        }

        composable(
            route = Screens.Profile.route,
        ) {
            Page4Screen(navController = navController)
        }

        composable(
            route = Screens.Transaction.route,
        ) {
            TransactionScreen(navController)
        }

        composable(
            route = "${Screens.Confirm.route}/{amountValue}",
        ) {
            ConfirmScreen(
                navController = navController, value = it.arguments!!.getString(
                    "amountValue"
                )!!
            )
        }

        composable(route = Screens.Finish.route) {
            FinishScreen(navController)
        }
    }
}

sealed class Screens(val route: String, val title: String? = "", val icon: Int? = 0) {
    data object Home : Screens(
        route = "home", icon = R.drawable.home
    )

    data object Wallet : Screens(
        route = "wallet", icon = R.drawable.wallet
    )

    data object Cole : Screens(
        route = "cole", icon = R.drawable.celo
    )

    data object Profile : Screens(
        route = "profile", icon = R.drawable.profile
    )

    data object Transaction : Screens(
        route = "transaction",
        title = "Transaction",
    )

    data object Confirm : Screens(
        route = "confirm/$AMOUNT_ARGUMENT_KEY"
    )

    data object Finish : Screens(
        route = "finish"
    )
}

const val AMOUNT_ARGUMENT_KEY = "amountValue"