package com.galvezsh.mvvm_login.ui.viewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _validEmail = MutableLiveData<Boolean>()
    val validEmail: LiveData<Boolean> = _validEmail

    fun onEmailChanged( email: String ) {
        _email.value = email
        _validEmail.value = isValidEmail( email )
    }

    private fun isValidEmail( email: String ): Boolean = Patterns.EMAIL_ADDRESS.matcher( email ).matches()

}