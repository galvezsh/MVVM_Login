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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.mvvm_login.R
import com.galvezsh.mvvm_login.ui.theme.Colors

@Preview( showBackground = true, showSystemUi = true )
@Composable
fun LoginScreen() {
    Box( modifier = Modifier.fillMaxSize().padding( 16.dp ) ) {
        Base( modifier = Modifier.align( Alignment.Center ) )
    }
}

@Composable
fun Base( modifier: Modifier ) {
    Column( modifier = modifier ) {
        HeaderImage( modifier = Modifier.align( Alignment.CenterHorizontally ) )
        Spacer( 16 )
        EmailField()
        Spacer( 4 )
        PasswordField()
        Spacer( 8 )
        ForgotPassword( modifier = Modifier.align( Alignment.End ))
        Spacer( 8 )
        LoginButton()
        Spacer( 16 )
        SignupText( modifier = Modifier.align( Alignment.CenterHorizontally ) )
        Spacer( 8 )
        SignupButton()
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
        painter = painterResource( id = R.drawable.ic_app ),
        contentDescription = "HeaderImage",
        modifier = modifier
            .size( 192.dp )
            .shadow(
                elevation = 12.dp,
                shape = CircleShape
            )
            .clip( CircleShape )
    )
}

@Composable
fun EmailField() {
    TextField(
        value = "",
        enabled = true,
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text( text = "Email" ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Email ),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun PasswordField() {
    TextField(
        value = "",
        enabled = true,
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text( text = "Password" ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
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
fun LoginButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth().height( 48.dp ),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.primaryAppColor,
            disabledContainerColor = Colors.secondaryAppColor,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) { Text( text = "Log In" ) }
}

@Composable
fun SignupText(modifier: Modifier) {
    Text(
        text = "Don't have an account? Sign Up for free!",
        fontSize = 14.sp,
        modifier = modifier,
        color = Color.Gray
    )
}

@Composable
fun SignupButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth().height( 48.dp ),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.primaryAppColor,
            disabledContainerColor = Colors.secondaryAppColor,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) { Text( text = "Sign Un" ) }
}
