package dev.soul.mycomposeexp.screens.page1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.soul.mycomposeexp.ui.theme.MyComposeExpTheme
import dev.soul.mycomposeexp.ui.theme.cursonColor
import dev.soul.mycomposeexp.ui.theme.edittextBack

@Composable
fun EmailEditText(inputValue: (String) -> Unit) {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val visualTransformation = if (isPasswordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    Box(
        modifier = Modifier
            .background(
                edittextBack,
                shape = RoundedCornerShape(16.dp)
            )
            .height(56.dp)
            .padding(end = 18.dp, start = 16.dp)
    ) {
        TextField(
            value = password,
            onValueChange = {
                password = it

                inputValue(password)

            },
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Email
            ),
            keyboardActions = KeyboardActions(onDone = {
                // Handle the "Done" action
            }),
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(text = "muftagiarm@gmail.com")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = cursonColor,
                textColor = cursonColor
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmailEditText() {
    MyComposeExpTheme {
        EmailEditText() {}
    }
}
