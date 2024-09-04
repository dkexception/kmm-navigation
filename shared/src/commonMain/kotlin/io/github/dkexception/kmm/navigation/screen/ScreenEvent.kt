package io.github.dkexception.kmm.navigation.screen

sealed class ScreenEvent {

    data object LoadNewScreen : ScreenEvent()

    data object OnBackAction : ScreenEvent()
}
