package com.example.calculator_kt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.calculator_kt.ui.theme.CalculatorTheme

@Composable
fun CalculatorView(
    modifier: Modifier = Modifier
) {

    var displayText by remember { mutableStateOf("0") }
    var userIsTypingNumber by remember { mutableStateOf(true) }
    val calculatorBrain by remember { mutableStateOf(CalculatorBrain()) }

    val onNumberClick: (String) -> Unit = { number ->

        if (userIsTypingNumber) {
            if (number == ".") {
                if (!displayText.contains(".")) {
                    displayText += number
                }
            } else {
                displayText = if (displayText == "0") number else displayText + number
            }
        } else {
            displayText = number
        }

        userIsTypingNumber = true
    }

    val onOperationClick: (String) -> Unit = { opLabel ->

        val op = CalculatorBrain.Operation.parse(opLabel)
        val result = calculatorBrain.performOperation(displayText.toDouble(), op)

        displayText =
            if (result % 1 == 0.0) result.toInt().toString()
            else result.toString()

        userIsTypingNumber = false
    }

    val onEqualsClick: (String) -> Unit = {

        val result = calculatorBrain.calculateFinal(displayText.toDouble())

        displayText =
            if (result % 1 == 0.0) result.toInt().toString()
            else result.toString()

        userIsTypingNumber = false
    }


    val onClearClick: (String) -> Unit = {
        calculatorBrain.clear()
        displayText = "0"
        userIsTypingNumber = true
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            displayText,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            fontSize = TextUnit(62f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold
        )

        Row {
            CalculatorButton(label = "7", onClick = onNumberClick)
            CalculatorButton(label = "8", onClick = onNumberClick)
            CalculatorButton(label = "9", onClick = onNumberClick)
            CalculatorButton(label = "+", isOperation = true, onClick = onOperationClick)
        }
        Row {
            CalculatorButton(label = "4", onClick = onNumberClick)
            CalculatorButton(label = "5", onClick = onNumberClick)
            CalculatorButton(label = "6", onClick = onNumberClick)
            CalculatorButton(label = "-", isOperation = true, onClick = onOperationClick)
        }
        Row {
            CalculatorButton(label = "1", onClick = onNumberClick)
            CalculatorButton(label = "2", onClick = onNumberClick)
            CalculatorButton(label = "3", onClick = onNumberClick)
            CalculatorButton(label = "÷", isOperation = true, onClick = onOperationClick)
        }
        Row {
            CalculatorButton(label = "0", onClick = onNumberClick)
            CalculatorButton(label = ".", onClick = onNumberClick)
            CalculatorButton(label = "C", isOperation = true, onClick = onClearClick)
            CalculatorButton(label = "×", isOperation = true, onClick = onOperationClick)
        }
        Row {
            CalculatorButton(label = "=", isOperation = true, onClick = onEqualsClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorViewPreview() {
    CalculatorTheme {
        CalculatorView()
    }
}
