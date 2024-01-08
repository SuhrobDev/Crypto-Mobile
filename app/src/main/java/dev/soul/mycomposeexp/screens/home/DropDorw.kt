package dev.soul.mycomposeexp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.soul.mycomposeexp.ui.theme.MyComposeExpTheme

@Composable
fun DropdownExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("USD 1") }

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        // Text displaying the selected option
        Text(
            text = "Selected: $selectedOption",
            modifier = Modifier
                .clickable { expanded = true }
                .padding(16.dp)
        )

        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(16.dp))
                .border(1.dp, MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small)
                .padding(4.dp)
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

@Preview(showBackground = true)
@Composable
fun PreviewDropdownExample() {
    MyComposeExpTheme {
        Surface(color = Color.White) {
            DropdownExample()
        }
    }
}
