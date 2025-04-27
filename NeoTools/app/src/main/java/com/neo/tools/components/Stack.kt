package com.neo.tools.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neo.tools.R

@Composable
fun Stack(
    onClick: () -> Unit,
    onClickAge: () -> Unit,
    onClickDateDifference: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Tool(
                image = R.drawable.calculator_calculator,
                text = "Calculator",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_age,
                text = "Age",
                modifier = Modifier.weight(1f),
                onClick = onClickAge
            )
            Tool(
                image = R.drawable.calculator_bmi,
                text = "BMI",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_average,
                text = "Average",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Tool(
                image = R.drawable.calculator_progression,
                text = "AP & GP",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_interest,
                text = "Interest",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_emi,
                text = "EMI",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_gst,
                text = "GST",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Tool(
                image = R.drawable.calculator_sip,
                text = "SIP",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_distance,
                text = "Distance",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_triangle,
                text = "Triangle",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
            Tool(
                image = R.drawable.calculator_quadratic,
                text = "Quadratic",
                modifier = Modifier.weight(1f),
                onClick = onClick
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Tool(
                image = R.drawable.calculator_hcf,
                text = "HCF",
                modifier = Modifier.weight(1f),
                onClick = onClickDateDifference
            )
            Tool(
                image = R.drawable.calculator_lcm,
                text = "LCM",
                modifier = Modifier.weight(1f),
                onClick = onClickDateDifference
            )
            Tool(
                image = R.drawable.calculator_matrix,
                text = "Matrix & Determinant",
                modifier = Modifier.weight(1f),
                onClick = onClickDateDifference
            )
            Tool(
                image = R.drawable.calculator_date_difference,
                text = "Date difference",
                modifier = Modifier.weight(1f),
                onClick = onClickDateDifference
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(20.dp)
        )
    }
}