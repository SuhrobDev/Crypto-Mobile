package dev.soul.mycomposeexp.screens.finish

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.soul.mycomposeexp.R
import dev.soul.mycomposeexp.navigation.Screens
import dev.soul.mycomposeexp.screens.transaction.confirm.Divider
import dev.soul.mycomposeexp.screens.transaction.confirm.arian700Font
import dev.soul.mycomposeexp.screens.transaction.confirm.ariana400Font

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinishScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
    ) {
        TopAppBar(navigationIcon = {
            Icon(painterResource(id = R.drawable.x_ic),
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

        }, actions = {
            Icon(painterResource(id = R.drawable.share_ic),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 24.dp)
                    .clip(
                        CircleShape
                    )
                    .clickable {

                    })
        })

        LazyColumn(content = {
            item {
                Spacer(modifier = Modifier.padding(28.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.done_ic),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.padding(24.dp))


                    Text(
                        text = "Payment successfully!",
                        fontSize = 16.sp,
                        fontFamily = ariana400Font,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center

                    )

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = "0.281902ETH",
                        fontSize = 28.sp,
                        fontFamily = arian700Font,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(32.dp))

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_eth3),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(bottom = 24.dp)
//                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp).padding(top = 32.dp)
                                .background(
                                    Color.White, RoundedCornerShape(24.dp)
                                )
                        ) {
                            Column(modifier = Modifier.padding(24.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    Text(
                                        text = "Coin",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font
                                    )
                                    Text(
                                        text = "Ethereum (ETH)",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font,
                                        color = Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.padding(14.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    Text(
                                        text = "Coin rate",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font
                                    )
                                    Text(
                                        text = "3,115.21/1eth",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font,
                                        color = Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.padding(14.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    Text(
                                        text = "Date",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font
                                    )
                                    Text(
                                        text = "14 April 2022",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font,
                                        color = Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.padding(14.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    Text(text = "Fee", fontSize = 14.sp, fontFamily = ariana400Font)
                                    Text(
                                        text = "10.25",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font,
                                        color = Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.padding(14.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.crop_line),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Spacer(modifier = Modifier.padding(14.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    Text(
                                        text = "Total",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font
                                    )
                                    Text(
                                        text = "200.25",
                                        fontSize = 14.sp,
                                        fontFamily = ariana400Font,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }


                }

            }

            item {
                Spacer(modifier = Modifier.padding(48.dp))
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
}