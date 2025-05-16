package com.galvezsh.mvvm_login.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.galvezsh.mvvm_login.R
import com.galvezsh.mvvm_login.ui.viewModel.ForgotPasswordViewModel

//@Preview( showBackground = true, showSystemUi = true )
@Composable
fun ForgotPasswordScreen( forgotPasswordViewModel: ForgotPasswordViewModel, oldEmail: String ) {

    val email: String by forgotPasswordViewModel.email.observeAsState( initial = oldEmail )
    val enabledButton: Boolean by forgotPasswordViewModel.validEmail.observeAsState( initial = false )

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
                onTextFieldChanged = { newEmail -> forgotPasswordViewModel.onEmailChanged( newEmail ) }
            )
            InvalidFieldText(
                text = "Invalid email",
                valid = enabledButton,
                modifier = Modifier.align( Alignment.CenterHorizontally ),
                paddingTop = 8.dp
            )
            Spacer( 8 )
            Button(
                text = "Recover Password",
                enabled = enabledButton,
                onPressedButton = {  }
            )
        }
    }
}

