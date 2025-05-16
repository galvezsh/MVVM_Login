package com.galvezsh.mvvm_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.galvezsh.mvvm_login.core.navigation.NavigationWrapper
import com.galvezsh.mvvm_login.ui.theme.MVVM_LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MVVM_LoginTheme {
                NavigationWrapper()
            }
        }
    }
}