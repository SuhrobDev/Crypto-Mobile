package dev.soul.mycomposeexp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.soul.mycomposeexp.R
import dev.soul.mycomposeexp.ui.theme.Primary


@Composable
fun BottomNav(navController: NavHostController) {

    val screens = listOf(
        Screens.Home,
        Screens.Wallet,
        Screens.Cole,
        Screens.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = Primary) {
        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route
    val selected = currentRoute == screen.route

    BottomNavigationItem(
        icon = {
            Column(modifier = Modifier) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = screen.icon!!),
                    contentDescription = "Navigation Icon",
                    tint = if (selected) Color(0xFF161414) else Color(0x4D161414).copy(0.9f),
                    modifier = Modifier.padding(bottom = 6.dp, start = 8.dp),
                )
                if (selected)
                    Icon(
                        painter = painterResource(id = R.drawable.bottom_menu_trigger),
                        contentDescription = null,
                    )

            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
//            if (navController.currentDestination!!.route == screen.route) return@BottomNavigationItem
//            navController.navigate(screen.route) {
//                popUpTo(navController.graph.findStartDestination().id)
//                launchSingleTop = true
//            }
            navController.navigate(screen.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

        },
        modifier = Modifier
            .background(Primary)

    )
}