package dev.soul.mycomposeexp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.soul.mycomposeexp.R
import dev.soul.mycomposeexp.navigation.Screens
import dev.soul.mycomposeexp.ui.theme.MyComposeExpTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val ariana400Font = FontFamily(Font(R.font.ariana_400))
    val arian700Font = FontFamily(Font(R.font.ariana_700))

    val list: ArrayList<CryptoModel> = ArrayList()

    list.add(
        CryptoModel("BTC", "$41,881.17", R.drawable.ic_bitcoin, "+0.44%", "18M Bitcoin")
    )
    list.add(
        CryptoModel("ETH", "$3,157.66", R.drawable.ic_eth, "-0.91%", "119k Ethereum")
    )
    list.add(
        CryptoModel("USDT", "$1.00", R.drawable.ic_usdt, "+1.02%", "78,2B Tether")
    )
    list.add(
        CryptoModel("BNB", "$439.04", R.drawable.ic_bnb, "+439.04%", "166K BNB")
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
    ) {
        Column {
            TopAppBar(modifier = Modifier.padding(horizontal = 24.dp),
                title = {},
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search_ic),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                            },
                    )
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        // First icon at the end
                        Icon(
                            painter = painterResource(id = R.drawable.search_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                }
                        )

                        // Second icon at the end
                        Icon(
                            painter = painterResource(id = R.drawable.notification_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable { }
                        )
                    }
                })

            BalanceCard {
                navController.navigate(Screens.Transaction.route)
            }

            BottomSheetScaffold(
                sheetContent = {
                    LazyColumn(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp), content = {

                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween
                            ) {
                                Text(
                                    text = "Market Trend",
                                    fontSize = 16.sp,
                                    fontFamily = arian700Font,
                                    color = Color.Black,
                                )


                                Row {
                                    Text(
                                        text = "24h",
                                        fontSize = 12.sp,
                                        fontFamily = ariana400Font,
                                        color = Color(0xFF5A5959),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )

                                    Icon(
                                        painter = painterResource(id = R.drawable.change_menu),
                                        contentDescription = null, tint = Color.Black
                                    )
                                }

                            }
                        }

                        item {
                            Spacer(modifier = Modifier.padding(6.dp))
                        }

                        items(list.size) {
                            val crypto = list[it]
                            CryptoItem(
                                crypto = crypto,
                                font1 = arian700Font,
                                font2 = ariana400Font
                            )

                        }
//
//                        items(list.size, key = {
//                            list[it]
//                        }, itemContent = {
//
//                        })
                    })
                },
                sheetShadowElevation = 0.dp,
                sheetContainerColor = Color.White,
                sheetSwipeEnabled = false,
                sheetPeekHeight = 380.dp,
                scaffoldState = rememberBottomSheetScaffoldState()
            ) {
                Column(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }


}

@Composable
fun BalanceCard(deposit: () -> Unit) {
    val ariana400Font = FontFamily(Font(R.font.ariana_400))
    val arian700Font = FontFamily(Font(R.font.ariana_700))

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("USD 1") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .padding(start = 24.dp)
    ) {
        Row(modifier = Modifier) {
            Text(
                text = "Your Balance",
                fontSize = 16.sp,
                fontFamily = ariana400Font,
                color = Color(0xFF9D9C9C)
            )
            Icon(
                painterResource(id = R.drawable.arrow_circle_right),
                contentDescription = null,
                modifier = Modifier.padding(start = 6.dp),
            )
        }
        Row(
            modifier = Modifier
                .padding(end = 30.dp)
                .padding(top = 6.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$28,718.78",
                fontSize = 32.sp,
                fontFamily = arian700Font,
                color = Color.Black
            )


            Box(
                modifier = Modifier

                    .background(Color.White, shape = RoundedCornerShape(50.dp))
                    .clip(CircleShape)
                    .padding(horizontal = 4.dp)
                    .padding(end = 4.dp)
                    .height(35.dp)
                    .width(71.dp)
                    .clickable { expanded = true }


            ) {
                // Text displaying the selected option
                Row {
                    Text(
                        text = selectedOption,
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(start = 2.dp)
                            .align(Alignment.CenterVertically), fontSize = 12.sp,
                        fontFamily = arian700Font,
                        color = Color(0xFF161414)
                    )

                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }

                // Dropdown menu
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            4.dp,
                            MaterialTheme.colorScheme.primary,
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(4.dp)
                        .clip(CircleShape)
                ) {
                    DropdownMenuItem(text = {
                        Text("USD 1", color = Color.Black)

                    }, onClick = {
                        selectedOption = "USD 1"
                        expanded = false
                    })

                    DropdownMenuItem(text = {
                        Text("USDT 2", color = Color.Black)

                    }, onClick = {
                        selectedOption = "USDT 2"
                        expanded = false
                    })
                }
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Box(modifier = Modifier.background(Color(0xFF59BC7C), RoundedCornerShape(27.dp))) {
            Text(
                text = "+2.57%", color = Color.White, modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(vertical = 4.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween) {
            Image(
                painterResource(id = R.drawable.diagram_png),
                contentDescription = null,
                modifier = Modifier.width(173.dp)
            )

            Deposit(
                onClickDeposit = {
                    deposit()
                },
                font = ariana400Font
            )

            Spacer(modifier = Modifier.padding(12.dp))

            Withdraw(
                onClickWithdraw = {

                },
                font = ariana400Font
            )
        }

    }
}

@Composable
fun CryptoItem(crypto: CryptoModel, font1: FontFamily, font2: FontFamily) {
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Row {
            Image(
                painterResource(id = crypto.icon),
                contentDescription = null,
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                Text(
                    text = crypto.name,
                    fontSize = 16.sp,
                    fontFamily = font1.also { FontWeight(23) },
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = crypto.about,
                    fontSize = 12.sp,
                    fontFamily = font2,
                    color = Color(0xFF9F9E9E)
                )
            }
        }

        Column {
            Text(
                text = crypto.price,
                fontSize = 16.sp,
                fontFamily = font1,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Box(
                modifier = Modifier
                    .background(
                        Color(0xFF59BC7C),
                        shape = RoundedCornerShape(27.dp)
                    )
                    .align(Alignment.End)
            ) {
                Text(
                    text = crypto.growth,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 8.dp)
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}

data class CryptoModel(
    val name: String,
    val price: String,
    val icon: Int,
    val growth: String,
    val about: String
)


@Composable
fun Deposit(onClickDeposit: () -> Unit, font: FontFamily) {
    Column {
        Box(
            modifier = Modifier
                .background(Color(0xFF59BC7C), shape = CircleShape)
                .size(64.dp)
                .clip(CircleShape)
                .clickable {
                    onClickDeposit()
                }
        ) {
            Icon(
                painterResource(id = R.drawable.send),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center), tint = Color.White
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = "Deposit", fontSize = 12.sp, fontFamily = font, color = Color(0xFF5A5959))
    }
}

@Composable
fun Withdraw(onClickWithdraw: () -> Unit, font: FontFamily) {
    Column {
        Box(
            modifier = Modifier
                .background(Color.Black, shape = CircleShape)
                .size(64.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.received),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onClickWithdraw()
                    }
                    .align(Alignment.Center), tint = Color.White)
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = "Withdraw", fontSize = 12.sp, fontFamily = font, color = Color(0xFF5A5959))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBalance() {
    MyComposeExpTheme {
        BalanceCard(deposit = {})
    }
}

