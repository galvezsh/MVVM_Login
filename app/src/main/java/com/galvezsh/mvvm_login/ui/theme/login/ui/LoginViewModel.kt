package com.galvezsh.mvvm_login.ui.theme.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class LoginViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged( email: String, password: String ) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    suspend fun onLoginSelected( email: String, password: String ) {
        _isLoading.value = true

        delay(5000)

        _isLoading.value = false

    }

    private fun isValidEmail( email: String ): Boolean = Patterns.EMAIL_ADDRESS.matcher( email ).matches()

    private fun isValidPassword( password: String ): Boolean = password.length >= 8

}