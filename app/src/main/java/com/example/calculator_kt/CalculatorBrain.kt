package com.example.calculator_kt

class CalculatorBrain {

    var operand: Double = 0.0
    private var pendingOperation: Operation? = null

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE;

        companion object {
            fun parse(value: String): Operation {
                return when (value) {
                    "+" -> ADD
                    "-" -> SUBTRACT
                    "×" -> MULTIPLY
                    "÷" -> DIVIDE
                    else -> throw IllegalArgumentException("Invalid operation")
                }
            }
        }
    }

    fun performOperation(newOperand: Double, op: Operation): Double {

        operand = if (pendingOperation == null) {
            newOperand
        } else {
            when (pendingOperation) {
                null -> newOperand
                Operation.ADD -> operand + newOperand
                Operation.SUBTRACT -> operand - newOperand
                Operation.MULTIPLY -> operand * newOperand
                Operation.DIVIDE -> operand / newOperand
            }
        }

        pendingOperation = op
        return operand
    }

    fun calculateFinal(newOperand: Double): Double {

        if (pendingOperation == null) {
            return newOperand
        }

        operand = when (pendingOperation) {

            Operation.ADD -> operand + newOperand
            Operation.SUBTRACT -> operand - newOperand
            Operation.MULTIPLY -> operand * newOperand
            Operation.DIVIDE -> operand / newOperand
            null -> newOperand
        }

        pendingOperation = null
        return operand
    }

    fun clear() {
        operand = 0.0
        pendingOperation = null
    }
}
