package io.github.dkexception.kmm.navigation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.dkexception.kmm.navigation.navigation.Navigator
import io.github.dkexception.kmm.navigation.snackbar.ISnackbarHelper
import io.github.dkexception.kmm.navigation.utils.Constants
import kotlinx.coroutines.CoroutineScope

class ScreenViewModel(
    coroutineScope: CoroutineScope,
    private val navigator: Navigator,
    private val snackbarHelper: ISnackbarHelper
) : ViewModel(), IScreenViewModel {

    private val mScope = if (navigator.isAndroid) {
        viewModelScope
    } else {
        coroutineScope
    }

    override fun onEvent(screenEvent: ScreenEvent) {
        when (screenEvent) {

            ScreenEvent.LoadNewScreen -> navigator.navigate(Constants.NavigationRoutes.SCREEN)

            ScreenEvent.OnBackAction -> navigator.goBack()
        }
    }
}
