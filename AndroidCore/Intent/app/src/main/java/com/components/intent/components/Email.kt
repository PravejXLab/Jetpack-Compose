package com.components.intent.components

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SendEmail() {
    val context = LocalContext.current
    var sendTo by rememberSaveable { mutableStateOf("") }
    var subject by rememberSaveable { mutableStateOf("") }
    var message by rememberSaveable { mutableStateOf("") }
    var recipients by rememberSaveable { mutableStateOf(listOf("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = sendTo,
                onValueChange = { sendTo = it },
                label = { Text("Send To") },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = {
                        if (sendTo.isNotBlank()) {
                            recipients += sendTo
                            sendTo = ""
                        }
                    }) {
                        Icon(Icons.Default.Add, "Add Recipient")
                    }
                }
            )
        }
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = subject,
            onValueChange = { subject = it },
            label = { Text("Subject") },
            singleLine = true
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Type your Email") }
        )
        Spacer(Modifier.height(100.dp))
        OutlinedButton(onClick = {
            try {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, recipients.toTypedArray())
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, message)
                }
                context.startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Send")
        }
        Column(Modifier.fillMaxWidth()) {
            Text("Your Recipients:", Modifier.padding(8.dp))
            LazyColumn {
                items(recipients) { recipient ->
                    if (recipient.isNotBlank()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(recipient, Modifier.weight(1f))
                            IconButton(onClick = { recipients -= recipient }) {
                                Icon(Icons.Default.Delete, "Delete Recipient")
                            }
                        }
                    }
                }
            }
        }
    }
}