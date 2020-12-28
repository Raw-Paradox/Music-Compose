package com.cyb.musicplayer.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

/**
 * Created by Paradoox on 2020/12/23.
 */

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    loginAction: (String, String) -> Unit
) {
    var username by remember { mutableStateOf("18831998610") }
    var password by remember { mutableStateOf("WYY020516cyb") }
    Column(
        modifier = modifier.padding(top = 50.dp, start = 30.dp, end = 30.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = { username = it },
            leadingIcon = { Icon(Icons.Filled.AccountBox) },
            backgroundColor = Color.White,
            placeholder = { Text("username") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onImeActionPerformed = { imeAction, softwareKeyboardController ->
                // TODO move cursor to password TextField
            }
        )
        TextField(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp).focus(),
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Filled.Lock) },
            backgroundColor = Color.White,
            placeholder = { Text("password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            onImeActionPerformed = { imeAction, softwareKeyboardController ->
                if (username.isNotBlank() and password.isNotBlank() and (imeAction == ImeAction.Done)) {
                    loginAction(username, password)
                }
            }
        )

        Row(
            modifier = Modifier.padding(top = 16.dp).padding(horizontal = 7.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text("Remember me", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            var checked by remember { mutableStateOf(false) }
            Switch(checked = checked, onCheckedChange = { checked = it })
        }
        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 17.dp)
                .preferredHeight(50.dp)
                .clip(RoundedCornerShape(17.dp)),
            enabled = username.isNotBlank() and password.isNotBlank(),
            onClick = { loginAction(username, password) }) {
            Text("LOGIN")
        }
    }
}
