package com.galvezsh.mvvm_login.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.galvezsh.mvvm_login.R
import com.galvezsh.mvvm_login.ui.viewModel.LoginViewModel
import kotlinx.coroutines.launch

//@Preview( showBackground = true, showSystemUi = true )
@Composable
fun LoginScreen( loginViewModel: LoginViewModel, navigateToForgotPasswordScreen: (String) -> Unit, navigateToRegisterScreen: () -> Unit ) {

    val email: String by loginViewModel.email.observeAsState( initial = "" )
    val password: String by loginViewModel.password.observeAsState( initial = "" )
    val validEmail: Boolean by loginViewModel.validEmail.observeAsState( initial = false )
    val validPassword: Boolean by loginViewModel.validPassword.observeAsState( initial = false )
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState( initial = false )
    val coroutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box( modifier = Modifier.fillMaxSize() ) {
            CircularProgressIndicator( modifier = Modifier.align( Alignment.Center ) )
        }

    } else {
        Box( modifier = Modifier.fillMaxSize().padding( 16.dp ) ) {
            Column( modifier = Modifier.align( Alignment.Center ) ) {
                CircleImage(
                    modifier = Modifier.align( Alignment.CenterHorizontally ),
                    id = R.drawable.ic_app_2,
                    size = 168.dp
                )
                Spacer( 16 )
                EmailField(
                    email = email,
                    onTextFieldChanged = { newEmail -> loginViewModel.onLoginChanged( newEmail, password ) }
                )
                Spacer( 4 )
                PasswordField(
                    password = password,
                    onTextFieldChanged = { newPassword -> loginViewModel.onLoginChanged( email, newPassword ) }
                )
                InvalidFieldText(
                    text = "Invalid email",
                    valid = validEmail,
                    modifier = Modifier.align( Alignment.CenterHorizontally ),
                    paddingTop = 8.dp
                )
                InvalidFieldText(
                    text = "The password must have at least 8 characters",
                    valid = validPassword,
                    modifier = Modifier.align( Alignment.CenterHorizontally ),
                    paddingTop = 8.dp
                )
                Spacer( 8 )
                TextLink (
                    modifier = Modifier.align( Alignment.End ),
                    text = "Forgot Password?",
                    onPressedLink = { navigateToForgotPasswordScreen( email ) }
                )
                Spacer( 8 )
                Button(
                    text = "Log In",
                    enabled = (validEmail && validPassword),
                    onPressedButton = { coroutineScope.launch { loginViewModel.onLoginSelected( email, password ) } }
                )
                Spacer( 8 )
                TextLink(
                    modifier = Modifier.align( Alignment.CenterHorizontally ),
                    text = "Don't have an account? Sign Up for free!",
                    onPressedLink = { navigateToRegisterScreen() }
                )
            }
        }
    }
}
