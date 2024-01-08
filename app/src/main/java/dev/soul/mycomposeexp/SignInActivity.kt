package dev.soul.mycomposeexp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.soul.mycomposeexp.screens.page1.Inputs
import dev.soul.mycomposeexp.screens.page1.TopBar
import dev.soul.mycomposeexp.ui.theme.MyComposeExpTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val arian700Font = FontFamily(Font(R.font.ariana_700))

            MyComposeExpTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { TopBar(font = arian700Font) },
                    content = {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it)
                        ) {
                            Spacer(modifier = Modifier.padding(48.dp))
                            Inputs(emailInput = {

                            }, passwordInput = {

                            }, font = arian700Font)
                            Spacer(modifier = Modifier.padding(12.dp))

                            val text = "Forgot password?"

                            val annotatedString = buildAnnotatedString {
                                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                    append(text)
                                }
                            }

                            //to open url
                            val context = LocalContext.current
                            val uriHandler = LocalUriHandler.current

                            Text(
                                text = annotatedString,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                textAlign = TextAlign.End,
                                color = Color(0xFF161414),
                            )

                            Spacer(modifier = Modifier.padding(32.dp))


                            Button(
                                shape = RoundedCornerShape(16.dp),
                                onClick = {

                                    startActivity(
                                        Intent(
                                            this@SignInActivity,
                                            MainActivity::class.java
                                        )
                                    )
                                    finish()
                                },
                                modifier = Modifier
                                    .height(56.dp)
                                    .fillMaxWidth()
                                    .padding(horizontal = 24.dp)
                                    .background(
                                        Color.White,
                                        shape = RoundedCornerShape(16.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(Color(0xFF000000))
                            ) {
                                Text(
                                    text = "Continue",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 8.dp),
                                    textAlign = TextAlign.Center,
                                    fontSize = 14.sp,
                                    fontFamily = arian700Font,
                                    color = Color.White,
                                )
                            }

                            Spacer(modifier = Modifier.padding(48.dp))

                            val register =
                                "Register" // Change this to the word you want to color differently
                            val account =
                                "Don’t have account? " // Change this to the word you want to color differently

                            val text1 = "Don’t have account? Register"

                            val registerTest = buildAnnotatedString {
                                val startIndex = text1.indexOf(register)
                                val endIndex = startIndex + register.length

                                val s1 = text1.indexOf(account)
                                val e1 = s1 + account.length


                                append(text1)

                                // Apply color to the specified range
                                withStyle(style = SpanStyle(color = Color.Black)) {
                                    addStyle(
                                        SpanStyle(color = Color.Black, fontFamily = arian700Font),
                                        startIndex,
                                        endIndex
                                    )
                                }
                                withStyle(style = SpanStyle(color = Color(0xFF737272))) {
                                    addStyle(
                                        SpanStyle(
                                            color = Color(0xFF737272)
                                        ),
                                        s1,
                                        e1
                                    )
                                }
                            }
                            Text(
                                text = registerTest,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                        }
                    }
                )
            }
        }
    }
}
