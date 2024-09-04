package io.github.dkexception.kmm.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import io.github.dkexception.kmm.navigation.di.initKoin
import io.github.dkexception.kmm.navigation.navigation.KMMNavigationAppNavHost
import io.github.dkexception.kmm.navigation.snackbar.ISnackbarHelper
import io.github.dkexception.kmm.navigation.utils.ObserveAsEvents
import kotlinx.coroutines.launch

@Composable
fun App(
    snackbarHelper: ISnackbarHelper,
    navHostController: NavHostController = rememberNavController()
) {

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()

    ObserveAsEvents(
        flow = snackbarHelper.events,
        key1 = snackbarHostState
    ) { event ->
        scope.launch {

            snackbarHostState.currentSnackbarData?.dismiss()

            val result = snackbarHostState.showSnackbar(
                message = event.message,
                actionLabel = event.action?.name,
                duration = SnackbarDuration.Short
            )

            if (result == SnackbarResult.ActionPerformed) {
                event.action?.action?.invoke()
            }
        }
    }

    AppContent(snackbarHostState, navHostController)
}

@Composable
private fun AppContent(
    snackbarHostState: SnackbarHostState,
    navHostController: NavHostController
) = Scaffold(
    modifier = Modifier.fillMaxSize(),
    contentWindowInsets = WindowInsets(0, 0, 0, 0),
    snackbarHost = {
        SnackbarHost(
            hostState = snackbarHostState
        )
    }
) { innerPadding ->
    KMMNavigationAppNavHost(
        navHostController = navHostController,
        modifier = Modifier.padding(innerPadding)
    )
}

@Preview
@Composable
private fun AppPreview() {

    initKoin()

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    AppContent(snackbarHostState, rememberNavController())
}
