package io.github.dkexception.kmm.navigation.di

import io.github.dkexception.kmm.navigation.screen.IScreenViewModel
import io.github.dkexception.kmm.navigation.screen.ScreenViewModel
import io.github.dkexception.kmm.navigation.snackbar.ISnackbarHelper
import io.github.dkexception.kmm.navigation.snackbar.SnackbarHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedViewModelModule = module {

    factory {
        CoroutineScope(Dispatchers.Default)
    }

    singleOf(::SnackbarHelper).bind<ISnackbarHelper>()

    viewModelOf(::ScreenViewModel).bind<IScreenViewModel>()
}
