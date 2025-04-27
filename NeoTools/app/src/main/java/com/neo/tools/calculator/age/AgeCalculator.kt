package com.neo.tools.calculator.age

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neo.tools.components.DatePickerCalculator
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.Date
import java.util.Locale

@Composable
fun AgeCalculator(navController: NavController) {
    var dobInput by remember { mutableStateOf<Long?>(null) }
    var result by remember { mutableStateOf<Period>(Period.ZERO) }
    var visible by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var formattedDate by remember { mutableStateOf("") }

    DatePickerCalculator(
        showDatePicker = showDatePicker,
        onClick = { showDatePicker = false },
        onDateSelected = { selectedDate ->
            dobInput = selectedDate
        }
    )

    dobInput?.let {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        formattedDate = formatter.format(Date(dobInput!!))

    }

    Scaffold(
        topBar = { TopBarAge(
            onClick = { navController.popBackStack() }
        ) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "DOB:    ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = formattedDate,
                    readOnly = true,
                    singleLine = true,
                    textStyle = TextStyle(fontWeight = FontWeight.Bold),
                    onValueChange = {},
                    label = { Text("Enter DOB:") },
                    trailingIcon = {
                        IconButton(
                            onClick = { showDatePicker = true }
                        ) {
                            Icon(Icons.Default.DateRange, "Select date")
                        }
                    }
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        visible = true
                        val brokenDob = formattedDate.split("/")

                        val dob = LocalDate.of(brokenDob[2].toInt(), brokenDob[1].toInt(), brokenDob[0].toInt())
                        val date = LocalDate.now()

                        result = Period.between(dob, date)
                    }
                ) {
                    Text(
                        text = "Calculate",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            if (visible) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${result.years} year, ${result.months} months, ${result.days} days",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}



