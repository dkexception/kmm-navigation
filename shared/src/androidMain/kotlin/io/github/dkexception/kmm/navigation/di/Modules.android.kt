package io.github.dkexception.kmm.navigation.di

import io.github.dkexception.kmm.navigation.navigation.AndroidNavigator
import io.github.dkexception.kmm.navigation.navigation.Navigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule: Module = module {

    singleOf(::AndroidNavigator).bind<Navigator>()
}
