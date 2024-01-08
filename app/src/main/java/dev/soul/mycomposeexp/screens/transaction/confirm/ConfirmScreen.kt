package dev.soul.mycomposeexp.screens.transaction.confirm

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.soul.mycomposeexp.R
import dev.soul.mycomposeexp.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmScreen(navController: NavController, value: String) {

    val fee = 10.25
    val amount = value.trim().toDouble()
    var isClickable by remember { mutableStateOf(false) }

    val text = (amount + fee).toString()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6)),
        content = {
            //topbar
            item {
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

            }

//            card
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .background(
                            Color.White, RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Text(
                            text = "You pay",
                            fontSize = 16.sp,
                            fontFamily = ariana400Font,
                            color = Color(0xFFBAB9B9)
                        )


                        Text(
                            text = "$$text",
                            fontSize = 24.sp,
                            fontFamily = arian700Font,
                            color = Color.Black,
                            modifier = Modifier.padding(8.dp)
                        )
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.crop_line),
                                contentDescription = null,
                                modifier = Modifier.padding(top = 28.dp)
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color(0xFF59BC7C), shape = CircleShape)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .weight(1f)
                                    .clickable {

                                    }
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.swap_ic),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Alignment.Center), tint = Color.White
                                )
                            }
                        }

                        Text(
                            text = "You receive",
                            fontSize = 16.sp,
                            fontFamily = ariana400Font,
                            color = Color(0xFFBAB9B9),
                            modifier = Modifier.padding(top = 8.dp)
                        )



                        Text(
                            text = "0.281902ETH",
                            fontSize = 24.sp,
                            fontFamily = arian700Font,
                            color = Color.Black,
                            modifier = Modifier.padding(8.dp)
                        )


                    }


                }
            }


            //detail
            item {
                Divider()
                PaymentDetail(total = text, fee = fee.toString())
            }

            //payment method
            item {
                Spacer(modifier = Modifier.padding(20.dp))
                PaymentMethod()
            }
            item {
                Divider()
                Divider()
                Divider()
            }
            item {
                Button(
                    shape = RoundedCornerShape(16.dp),
                    onClick = {
                        navController.navigate(Screens.Finish.route)
                    },
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0xFF59BB7C))
                ) {

                    Text(text = "Confirm to pay", fontSize = 16.sp)

                    Spacer(modifier = Modifier.padding(4.dp))

                    Icon(
                        painterResource(id = R.drawable.arrow_right),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Divider()
            }
        })
}

val ariana400Font = FontFamily(Font(R.font.ariana_400))
val arian700Font = FontFamily(Font(R.font.ariana_700))
val grey = Color(0xFF9C9B9B)

@Composable
fun PaymentDetail(total: String, fee: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {

        Text(
            text = "Transaction detail",
            fontSize = 16.sp,
            color = Color.Black,
            fontFamily = ariana400Font
        )
        Divider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(text = "Date", fontSize = 14.sp, fontFamily = ariana400Font, color = grey)
            Text(
                text = "14 April 2022",
                fontSize = 14.sp,
                fontFamily = ariana400Font,
                color = Color.Black
            )
        }
        Divider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(text = "Fee", fontSize = 14.sp, fontFamily = ariana400Font, color = grey)
            Text(
                text = fee,
                fontSize = 14.sp,
                fontFamily = ariana400Font,
                color = Color.Black
            )
        }
        Divider()

        Image(painter = painterResource(id = R.drawable.line2), contentDescription = null)
        Divider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(text = "Total", fontSize = 14.sp, fontFamily = ariana400Font, color = grey)
            Text(
                text = total,
                fontSize = 16.sp,
                fontFamily = arian700Font,
                color = Color.Black
            )
        }
    }
}

@Composable
fun PaymentMethod() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("**** **** **** 2172") }
    var selectedIcon by remember { mutableIntStateOf(R.drawable.mastercard) }

    Column {
        Text(
            text = "Payment method",
            fontSize = 16.sp,
            fontFamily = ariana400Font,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.padding(14.dp))
        var dropdownMenuState by remember { mutableStateOf(0.dp) }

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
                            text = "Mastercard",
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
                            painter = painterResource(id = R.drawable.mastercard),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            "**** **** **** 2172",
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }, onClick = {
                    selectedOption = "**** **** **** 2172"
                    selectedIcon = R.drawable.mastercard
                    expanded = false
                })

            }

        }
    }
}

@Composable
fun Divider() {
    Spacer(modifier = Modifier.padding(18.dp))
}