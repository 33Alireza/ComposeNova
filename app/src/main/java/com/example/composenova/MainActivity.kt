package com.example.composenova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.composenova.ui.theme.ComposeNovaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNovaTheme {
                var name by remember { mutableStateOf("") }
                var names by remember { mutableStateOf(listOf<String>()) }
                Column(
                    modifier = Modifier
                        .padding(vertical = 50.dp, horizontal = 16.dp)
                        .fillMaxSize(),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.weight(1f), value = name, onValueChange = { text ->
                                name = text
                            })
                        Spacer(Modifier.width(16.dp))
                        Button(
                            onClick = {
                                names = names + name
                            }) {
                            Text("Add")
                        }
                    }
                    LazyColumn {
                        items(names) { currentName ->
                            Text(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp), text = currentName
                            )
                            HorizontalDivider(
                                Modifier, DividerDefaults.Thickness, DividerDefaults.color
                            )
                        }
                    }
                }
            }
        }
    }
}