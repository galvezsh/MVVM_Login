package com.galvezsh.mvvm_login.ui.theme.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.mvvm_login.R
import com.galvezsh.mvvm_login.ui.theme.Colors
import kotlinx.coroutines.launch

//@Preview( showBackground = true, showSystemUi = true )
@Composable
fun LoginScreen( loginViewModel: LoginViewModel ) {
    Box( modifier = Modifier.fillMaxSize().padding( 16.dp ) ) {
        Base( modifier = Modifier.align( Alignment.Center ), loginViewModel )
    }
}

@Composable
fun Base( modifier: Modifier, loginViewModel: LoginViewModel ) {

    val email: String by loginViewModel.email.observeAsState( initial = "" )
    val password: String by loginViewModel.password.observeAsState( initial = "" )
    val loginEnabled: Boolean by loginViewModel.loginEnabled.observeAsState( initial = false )
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState( initial = false )
    val corrutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box( modifier = Modifier.fillMaxSize() ) {
            CircularProgressIndicator( modifier = Modifier.align( Alignment.Center ) )
        }
    } else {
        Column( modifier = modifier ) {
            HeaderImage( modifier = Modifier.align( Alignment.CenterHorizontally ) )
            Spacer( 16 )
            EmailField( email ) { loginViewModel.onLoginChanged( it, password ) }
            Spacer( 4 )
            PasswordField( password ) { loginViewModel.onLoginChanged( email, it ) }
            Spacer( 8 )
            ForgotPassword( modifier = Modifier.align( Alignment.End ))
            Spacer( 8 )
            LoginButton( loginEnabled ) { corrutineScope.launch { loginViewModel.onLoginSelected( email, password ) } }
            Spacer( 8 )
            SignupText( modifier = Modifier.align( Alignment.CenterHorizontally ) )
        }
    }
}

@Composable
fun Spacer( dp: Int ) {
    Spacer( modifier = Modifier.padding( dp.dp ) )
}

//@Composable
//fun Divider() {
//    HorizontalDivider(
//        color = Color.Gray,
//        thickness = 1.dp,
//        modifier = Modifier.padding(vertical = 8.dp)
//    )
//}

@Composable
fun HeaderImage( modifier: Modifier ) {
    Image(
        painter = painterResource( id = R.drawable.ic_app_2 ),
        contentDescription = "HeaderImage",
        modifier = modifier
            .size( 168.dp )
            .shadow( elevation = 12.dp, shape = CircleShape )
            .clip( CircleShape )
    )
}

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email,
        enabled = true,
        onValueChange = { onTextFieldChanged( it ) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape( 8.dp ),
        placeholder = { Text( text = "Email" ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Email ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedPlaceholderColor = Color( 0xFF636262 ),
            unfocusedPlaceholderColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun PasswordField( password: String, onTextFieldChanged: (String) -> Unit ) {
    var visiblePassword by remember { mutableStateOf(false) }

    TextField(
        value = password,
        enabled = true,
        onValueChange = { onTextFieldChanged( it ) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape( 8.dp ),
        visualTransformation = if (visiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text( text = "Password" ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedPlaceholderColor = Color( 0xFF636262 ),
            unfocusedPlaceholderColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val image = if (visiblePassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (visiblePassword) "Hide Password" else "Show Password"

            IconButton(
                onClick = { visiblePassword = !visiblePassword },
                colors = IconButtonDefaults.iconButtonColors( contentColor = Color(0xFF636262) )
            ) {
                Icon( imageVector = image, contentDescription = description )
            }
        }
    )
}

@Composable
fun ForgotPassword( modifier: Modifier ) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        modifier = modifier.clickable {  },
        fontWeight = FontWeight.Bold,
        color = Colors.primaryAppColor
    )
}

@Composable
fun LoginButton( loginEnabled: Boolean, onLoginSelected: () -> Unit ) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier.fillMaxWidth().height( 48.dp ),
        shape = RoundedCornerShape( 8.dp ),
        enabled = loginEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.primaryAppColor,
            disabledContainerColor = Colors.secondaryAppColor,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) { Text( text = "Log In" ) }
}

@Composable
fun SignupText( modifier: Modifier ) {
    Text(
        text = "Don't have an account? Sign Up for free!",
        fontSize = 14.sp,
        modifier = modifier.clickable {  },
        fontWeight = FontWeight.Bold,
        color = Colors.primaryAppColor
    )
}
