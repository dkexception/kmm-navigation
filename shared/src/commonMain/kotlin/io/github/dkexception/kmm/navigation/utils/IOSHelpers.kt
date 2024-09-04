package io.github.dkexception.kmm.navigation.utils

import io.github.dkexception.kmm.navigation.navigation.Navigator
import io.github.dkexception.kmm.navigation.screen.IScreenViewModel
import io.github.dkexception.kmm.navigation.screen.ScreenViewModel
import io.github.dkexception.kmm.navigation.snackbar.ISnackbarHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IOSHelpers : KoinComponent {

    @Suppress("MemberVisibilityCanBePrivate") // Used in iOS
    val navigator: Navigator by inject()

    @Suppress("MemberVisibilityCanBePrivate") // Used in iOS
    val snackbarHelper: ISnackbarHelper by inject()

    val coroutineScope: CoroutineScope by inject()

    fun cancel(coroutineScope: CoroutineScope) {
        coroutineScope.cancel()
    }

    fun provideScreenViewModel(
        coroutineScope: CoroutineScope
    ): IScreenViewModel = ScreenViewModel(
        coroutineScope = coroutineScope,
        navigator = navigator,
        snackbarHelper = snackbarHelper
    )
}
