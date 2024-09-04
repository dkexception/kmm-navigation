package io.github.dkexception.kmm.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.dkexception.kmm.navigation.extensions.canGoBack
import io.github.dkexception.kmm.navigation.screen.ScreenViewModel
import io.github.dkexception.kmm.navigation.screens.Screen
import io.github.dkexception.kmm.navigation.screens.Screen404
import io.github.dkexception.kmm.navigation.utils.Constants
import org.koin.androidx.compose.koinViewModel

@Composable
fun KMMNavigationAppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) = NavHost(
    modifier = modifier,
    navController = navHostController,
    startDestination = Constants.NavigationRoutes.SCREEN
) {

    composable(Constants.NavigationRoutes.SCREEN) {
        val viewModel: ScreenViewModel = koinViewModel()
        Screen(
            canGoBack = navHostController.canGoBack(),
            onEvent = viewModel::onEvent
        )
    }

    composable(Constants.NavigationRoutes.SCREEN_404) {
        Screen404()
    }
}
