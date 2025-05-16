package com.galvezsh.mvvm_login.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.galvezsh.mvvm_login.ui.viewModel.RegisterViewModel

@Composable
fun RegisterScreen( registerViewModel: RegisterViewModel ) {
    Box( modifier = Modifier.fillMaxSize().padding( 16.dp ) ) {
        CircularProgressIndicator( modifier = Modifier.align( Alignment.Center ) )
    }
}