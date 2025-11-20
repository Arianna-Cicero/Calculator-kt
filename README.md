# 📱 Calculator App --- Kotlin + Jetpack Compose

A simple calculator developed in **Kotlin** using **Jetpack Compose**,
created as part of an academic project.\
It includes basic operations (+, --, ×, ÷), sequential calculations,
decimal input, a clear button, and state management through a dedicated
Calculator Brain.

------------------------------------------------------------------------

## ✨ Features

✔ Input of numbers (0--9)\
✔ Decimal point support\
✔ Basic math operations:\
- ➕ Addition\
- ➖ Subtraction\
- ✖️ Multiplication\
- ➗ Division\
✔ Sequential calculations (e.g., `5 + 3 = + 2 =`)\
✔ **C** (Clear) button\
✔ Logic separated into layers:\
- `CalculatorBrain` --- handles operations\
- `CalculatorView` --- UI and interaction\
✔ Fully built using Jetpack Compose\
✔ Automatic formatting (removes `.0` when result is an integer)

------------------------------------------------------------------------

## 🧠 Project Structure

    project/
    │
    ├── MainActivity.kt
    ├── CalculatorView.kt
    ├── CalculatorButton.kt
    ├── CalculatorBrain.kt
    │
    └── ui/
         ├── theme/
         └── (colors, typography, shapes...)

------------------------------------------------------------------------

## 🧮 Calculation Logic (CalculatorBrain)

The calculator engine is responsible for:

-   Storing intermediate results (`operand`)
-   Storing pending operations (`pendingOperation`)
-   Handling intermediate actions with `performOperation()`\
-   Calculating final results with `calculateFinal()`
-   Resetting everything using `clear()`

Supported operations:

``` kotlin
enum class Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }
```

------------------------------------------------------------------------

## 🎨 User Interface (Jetpack Compose)

The interface was created using:

-   `Column` and `Row` for layout organization\
-   `Button` components (Material 3)\
-   State management via `remember` and `mutableStateOf`\
-   A responsive display at the top

Example:

``` kotlin
Row {
    CalculatorButton("7", onClick = onNumberClick)
    CalculatorButton("8", onClick = onNumberClick)
    CalculatorButton("9", onClick = onNumberClick)
    CalculatorButton("+", isOperation = true, onClick = onOperationClick)
}
```

------------------------------------------------------------------------

## ▶️ How to Run

### 1. Clone the repository

``` bash
git clone https://github.com/Arianna-Cicero/Calculator-kt.git
```

------------------------------------------------------------------------

### 2. Open in Android Studio

-   File → Open → select the project folder

------------------------------------------------------------------------

### 3. Run on:

### 🟢 Android Emulator

-   Tools → Device Manager\
-   Create a Pixel 4 / API 24\
-   Press Run ▶

### 🟢 Physical Android Device

-   Enable Developer Options\
-   Enable USB Debugging\
-   Connect via USB\
-   Press Run ▶

------------------------------------------------------------------------

## 📦 Technologies Used

-   **Kotlin**
-   **Jetpack Compose**
-   **Material Design 3**
-   **Android Studio**
-   **Compose State Management**

------------------------------------------------------------------------

## 📷 Screenshots (optional)

<img width="375" height="795" alt="image" src="https://github.com/user-attachments/assets/baa0ce68-8f71-4a78-b7e5-1c97d82a15c8" />



------------------------------------------------------------------------

## 👩‍💻 Author

**Arianna Cicero**\
Academic project --- Kotlin development with Jetpack Compose.

------------------------------------------------------------------------
