package com.galvezsh.mvvm_login.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.mvvm_login.ui.theme.Colors

@Composable
fun CircleImage( modifier: Modifier, id: Int, size: Dp) {
    Image(
        painter = painterResource( id = id ),
        contentDescription = "CircleImage",
        modifier = modifier
            .size( size )
            .shadow( elevation = 12.dp, shape = CircleShape )
            .clip( CircleShape )
    )
}

@Composable
fun Spacer( dp: Int ) {
    Spacer(modifier = Modifier.padding( dp.dp ))
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
fun InvalidFieldText( text: String, valid: Boolean, modifier: Modifier, paddingTop: Dp ) {
    if (!valid) {
        Text(
            text = text,
            color = Color.Red,
            modifier = modifier.padding( top = paddingTop )
        )
    }
}

@Composable
fun TextLink( modifier: Modifier, text: String, onPressedLink: () -> Unit ) {
    Text(
        text = text,
        fontSize = 12.sp,
        modifier = modifier.clickable { onPressedLink() },
        fontWeight = FontWeight.Bold,
        color = Colors.primaryAppColor
    )
}

@Composable
fun Button( text: String, enabled: Boolean, onPressedButton: () -> Unit ) {
    Button(
        onClick = { onPressedButton() },
        modifier = Modifier.fillMaxWidth().height( 48.dp ),
        shape = RoundedCornerShape( 8.dp ),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.primaryAppColor,
            disabledContainerColor = Colors.secondaryAppColor,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) { Text( text = text) }
}