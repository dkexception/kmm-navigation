package io.github.dkexception.kmm.navigation.extensions

import androidx.navigation.NavHostController

fun NavHostController.canGoBack(): Boolean = previousBackStackEntry != null
