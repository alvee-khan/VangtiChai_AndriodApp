
package com.example.vangtichai

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Current amount entered by the user
    private var amount = "0"

    // Amount display
    private lateinit var tvAmount: TextView

    // Available Taka denominations
    private val denominations = intArrayOf(
        500, 100, 50, 20, 10, 5, 2, 1
    )

    // IDs of note display TextViews
    private val noteIds = intArrayOf(
        R.id.tvNote500,
        R.id.tvNote100,
        R.id.tvNote50,
        R.id.tvNote20,
        R.id.tvNote10,
        R.id.tvNote5,
        R.id.tvNote2,
        R.id.tvNote1
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the XML interface
        setContentView(R.layout.activity_main)

        // Protect the interface from system bars and cutouts
        protectContentFromCutout()

        // Connect the amount display
        tvAmount = findViewById(R.id.tvAmount)

        // Restore amount after screen rotation
        amount = savedInstanceState?.getString("amount") ?: "0"

        // IDs of numeric buttons, ordered 0 to 9
        val digitButtons = intArrayOf(
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9
        )

        // Handle numeric button clicks
        digitButtons.forEachIndexed { digit, buttonId ->

            val button = findViewById<Button>(buttonId)

            button.setOnClickListener {
                addDigit(digit)
            }
        }

        // Handle CLEAR button
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnClear.setOnClickListener {
            amount = "0"
            updateDisplay()
        }

        // Display current amount and note counts
        updateDisplay()
    }

    // Add a digit to the current amount
    private fun addDigit(digit: Int) {

        val newAmount = if (amount == "0") {
            digit.toString()
        } else {
            amount + digit.toString()
        }

        // Prevent numeric overflow
        if (newAmount.toLongOrNull() != null) {
            amount = newAmount
            updateDisplay()
        }
    }

    // Calculate note counts and update the screen
    private fun updateDisplay() {

        tvAmount.text = amount

        var remaining = amount.toLong()

        denominations.forEachIndexed { index, note ->

            val count = remaining / note

            remaining %= note

            val noteTextView =
                findViewById<TextView>(noteIds[index])

            noteTextView.text = "$note: $count"
        }
    }

    // Save amount when the device rotates
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("amount", amount)
        super.onSaveInstanceState(outState)
    }

    // Keep content away from system bars and camera cutouts
    private fun protectContentFromCutout() {

        val root = findViewById<View>(R.id.main)
        val content = findViewById<View>(R.id.mainContent)

        val originalLeft = content.paddingLeft
        val originalTop = content.paddingTop
        val originalRight = content.paddingRight
        val originalBottom = content.paddingBottom

        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->

            val safeArea = insets.getInsets(
                WindowInsetsCompat.Type.displayCutout() or
                        WindowInsetsCompat.Type.systemBars()
            )

            content.setPadding(
                originalLeft + safeArea.left,
                originalTop,
                originalRight + safeArea.right,
                originalBottom
            )

            insets
        }

        ViewCompat.requestApplyInsets(root)
    }
}
