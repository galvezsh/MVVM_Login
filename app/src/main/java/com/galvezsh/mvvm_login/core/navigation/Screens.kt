package com.galvezsh.mvvm_login.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Register

@Serializable
data class ForgotPassword( val email: String )