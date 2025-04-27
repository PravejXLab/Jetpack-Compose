package com.neo.tools.calculator.date_difference

import  androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neo.tools.components.DatePickerCalculator
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.Period
import java.time.ZoneId
import java.util.Date
import java.util.Locale

@Composable
fun DateDifference(navController: NavController) {
    var fromDate by remember { mutableStateOf<Long?>(null) }
    var endDate by remember { mutableStateOf<Long?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    var isSelectingFromDate by remember { mutableStateOf(true) }
    var difference by remember { mutableStateOf<Period?>(null) }

    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    val formattedFromDate = fromDate?.let { dateFormatter.format(Date(it)) } ?: ""
    val formattedEndDate = endDate?.let { dateFormatter.format(Date(it)) } ?: ""

    if (showDatePicker) {
        DatePickerCalculator(
            showDatePicker = true,
            onClick = { showDatePicker = false },
            onDateSelected = { selectedDate ->
                if (isSelectingFromDate) fromDate = selectedDate else endDate = selectedDate
                showDatePicker = false
            }
        )
    }

    Scaffold(
        topBar = { TopBarDateDifference(onClick = { navController.popBackStack() }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "From: ",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = formattedFromDate,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Start Date") },
                    trailingIcon = {
                        IconButton(onClick = {
                            isSelectingFromDate = true
                            showDatePicker = true
                        }) {
                            Icon(Icons.Default.DateRange, "Select start date")
                        }
                    },
                    modifier = Modifier.fillMaxWidth().weight(4f)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "To: ",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(4f)
                )
                OutlinedTextField(
                    value = formattedEndDate,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("End Date") },
                    trailingIcon = {
                        IconButton(onClick = {
                            isSelectingFromDate = false
                            showDatePicker = true
                        }) {
                            Icon(Icons.Default.DateRange, "Select end date")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (fromDate != null && endDate != null) {
                        val start = Instant.ofEpochMilli(fromDate!!).atZone(ZoneId.systemDefault()).toLocalDate()
                        val end = Instant.ofEpochMilli(endDate!!).atZone(ZoneId.systemDefault()).toLocalDate()
                        difference = Period.between(start, end)
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Calculate", fontWeight = FontWeight.Bold)
            }

            difference?.let {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "${it.years} years, ${it.months} months, ${it.days} days",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
