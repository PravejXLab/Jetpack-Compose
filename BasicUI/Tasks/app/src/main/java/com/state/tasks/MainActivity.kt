package com.state.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.state.tasks.ui.theme.TasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasksTheme {
                Task()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task() {
    var task by remember { mutableStateOf("") }
    var taskItem by rememberSaveable { mutableStateOf(listOf<String>()) }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Tasks") })
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(10.dp).fillMaxSize()) {
            Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                TextField(value = task,
                    onValueChange = {task = it},
                    label = { Text("Enter new task...") },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Icon(imageVector = Icons.Default.AddCircle, "Add Task",
                    modifier = Modifier.align(Alignment.CenterEnd).size(40.dp)
                        .clickable { if(task.isNotBlank()) {
                            taskItem += task.trim()
                            task = ""
                        } },
                    tint = Color.Green)
            }

            Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                Row(modifier = Modifier.fillMaxWidth().height(50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text("Your Today's Tasks:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.align(Alignment.CenterStart))
                        Icon(Icons.Default.Delete, "Clear All",
                            modifier = Modifier.align(Alignment.CenterEnd)
                                .clickable { taskItem = emptyList() })
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(taskItem) {task ->
                        HorizontalDivider(color = Color.Gray)
                        val index = taskItem.indexOf(task)
                        Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                Text(task, fontWeight = FontWeight.Bold, fontSize = 20.sp,
                                    modifier = Modifier.align(Alignment.CenterStart))
                                Icon(Icons.Default.Delete, "Delete",
                                    modifier = Modifier.clickable { taskItem -= taskItem[index] }
                                        .align(Alignment.CenterEnd))
                            }
                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TasksTheme {
        Task()
    }
}