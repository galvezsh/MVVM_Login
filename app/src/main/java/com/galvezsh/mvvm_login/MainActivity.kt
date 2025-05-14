package com.galvezsh.mvvm_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.galvezsh.mvvm_login.ui.theme.MVVM_LoginTheme
import com.galvezsh.mvvm_login.ui.theme.login.ui.LoginScreen
import com.galvezsh.mvvm_login.ui.theme.login.ui.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MVVM_LoginTheme {
                LoginScreen( LoginViewModel() )
            }
        }
    }
}