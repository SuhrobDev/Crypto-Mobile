package dev.soul.mycomposeexp.screens.transaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.soul.mycomposeexp.R
import dev.soul.mycomposeexp.navigation.Screens
import dev.soul.mycomposeexp.ui.theme.MyComposeExpTheme
import dev.soul.mycomposeexp.ui.theme.cursonColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionScreen(navController: NavController) {
    val ariana400Font = FontFamily(Font(R.font.ariana_400))
    val arian700Font = FontFamily(Font(R.font.ariana_700))

    var amount by remember { mutableStateOf("0") }
    var isClickable by remember { mutableStateOf(false) }

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Ethereum") }
    var selectedIcon by remember { mutableIntStateOf(R.drawable.ic_eth) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
    ) {
        TopAppBar(navigationIcon = {
            Icon(painterResource(id = R.drawable.arrow_back),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .clip(
                        CircleShape
                    )
                    .clickable {
                        navController.navigateUp()
                    })
        }, title = {
            Text(
                text = "Transaction",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = arian700Font,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                textAlign = TextAlign.Justify
            )
        })
        Spacer(modifier = Modifier.padding(45.dp))
        var dropdownMenuState by remember { mutableStateOf(0.dp) }

        //currency drop down
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .clickable { expanded = true }
                .widthIn(max = dropdownMenuState),


            ) {
            // Text displaying the selected option
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = selectedIcon), contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = selectedOption,
                            modifier = Modifier,
                            fontSize = 12.sp,
                            fontFamily = arian700Font,
                            color = Color(0xFF161414)
                        )
                        Text(
                            text = selectedOption,
                            modifier = Modifier,
                            fontSize = 12.sp,
                            fontFamily = ariana400Font,
                            color = Color(0xFF737272)
                        )
                    }

                }


                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp)
                )
            }


            // Dropdown menu
            androidx.compose.material.DropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .background(
                        Color.White, shape = RoundedCornerShape(16.dp)
                    )
                    .onGloballyPositioned {
                        dropdownMenuState = it.size.width.dp
                    },
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(text = {
                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.ic_eth),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            "Ethereum",
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )

                    }

                }, onClick = {
                    selectedOption = "Ethereum"
                    selectedIcon = R.drawable.ic_eth
                    expanded = false
                })

                DropdownMenuItem(text = {
                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.ic_bitcoin),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            "Bitcoin",
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }, onClick = {
                    selectedOption = "Bitcoin"
                    selectedIcon = R.drawable.ic_bitcoin
                    expanded = false
                })

            }

        }

        //amount input

        AmountInput(input = {
            if (it.isNotEmpty()) isClickable = it.toDouble() > 0.0

            amount = "$it"

        }, fontFamily = ariana400Font, amount = amount, selectedOption)


        Button(
            shape = RoundedCornerShape(16.dp),
            onClick = {
                if (isClickable) navController.navigate("${Screens.Confirm.route}/$amount")
            },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = if (isClickable) ButtonDefaults.buttonColors(Color(0xFF59BB7C))
            else ButtonDefaults.buttonColors(Color(0xE652AE73))
        ) {

            Text(text = "Continue", fontSize = 16.sp)

            Spacer(modifier = Modifier.padding(4.dp))

            Icon(
                painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}


@Composable
fun AmountInput(
    input: (String) -> Unit, fontFamily: FontFamily, amount: String, selectedOption: String
) {
    var value by remember {
        mutableStateOf(amount)
    }
    val arian700Font = FontFamily(Font(R.font.ariana_700))
    val ariana400Font = FontFamily(Font(R.font.ariana_400))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Amount",
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontFamily = fontFamily,
            color = Color(0xFF9D9C9C),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )

        Row {
            Text(
                text = "$",
                fontFamily = arian700Font,
                fontSize = 28.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )

            TextField(value = value, onValueChange = {
                it?.let {
                    value = it

                    input(value)
                }

            }, keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Number
            ), keyboardActions = KeyboardActions(onDone = {
                // Handle the "Done" action
            }), modifier = Modifier.weight(1f), singleLine = true, placeholder = {
                androidx.compose.material.Text(
                    text = "0", fontSize = 28.sp, fontFamily = arian700Font
                )
            }, colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = cursonColor,
                textColor = cursonColor
            ), textStyle = TextStyle(
                fontFamily = arian700Font, fontSize = 28.sp, color = Color.Black
            )
            )

            if (value.isNotEmpty()) {
                Text(
                    text = if (selectedOption == "Bitcoin") {
                        (value.toDouble() / 44186.80).toString() + "BTC"
                    } else {
                        (value.toDouble() / 2245.25).toString() + "ETH"
                    },
                    fontSize = 12.sp,
                    fontFamily = ariana400Font,
                    color = Color(0xFF959494),
                    lineHeight = TextUnit(value = 32f, type = TextUnitType(1)),
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 14.dp)
                )
            }

        }


    }
}


@Composable
fun IconOverAnother() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .background(Color.White)
        )

        Icon(
            imageVector = Icons.Default.MailOutline,
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .background(Color.Green)
        )

        // Add more icons or components as needed
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewIconAboveComponents() {
    MyComposeExpTheme {
        IconOverAnother()
    }
}
