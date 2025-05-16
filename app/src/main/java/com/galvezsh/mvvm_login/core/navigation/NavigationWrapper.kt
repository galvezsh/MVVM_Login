package com.galvezsh.mvvm_login.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.galvezsh.mvvm_login.ui.view.ForgotPasswordScreen
import com.galvezsh.mvvm_login.ui.view.LoginScreen
import com.galvezsh.mvvm_login.ui.view.RegisterScreen
import com.galvezsh.mvvm_login.ui.viewModel.ForgotPasswordViewModel
import com.galvezsh.mvvm_login.ui.viewModel.LoginViewModel
import com.galvezsh.mvvm_login.ui.viewModel.RegisterViewModel


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost( navController = navController, startDestination = Login ) {

        composable<Login> {
            LoginScreen(
                LoginViewModel(),
                navigateToForgotPasswordScreen = { email -> navController.navigate( ForgotPassword( email = email ) ) },
                navigateToRegisterScreen = { navController.navigate( Register ) }
            )
        }

        composable<Register> {
            RegisterScreen(
                RegisterViewModel()
            )
        }

        composable<ForgotPassword> { backStackEntry ->
            val forgotPassword: ForgotPassword = backStackEntry.toRoute()

            ForgotPasswordScreen(
                ForgotPasswordViewModel(),
                forgotPassword.email
            )
        }

    }
}

