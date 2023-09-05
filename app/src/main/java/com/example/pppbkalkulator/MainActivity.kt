// MainActivity.kt
package com.example.pppbtugaskalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.pppbkalkulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var operand1: Double = 0.0
    private var operator: String = ""
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun inputNilai(view: View) {
        with(binding) {
            val buttonText = (view as Button).text.toString()
            if (operator.isEmpty()) {
                operand1 = operand1 * 10 + buttonText.toDouble()
                viewResult.text = operand1.toString()
            } else {
                operand2 = operand2 * 10 + buttonText.toDouble()
                viewResult.text = operand2.toString()
            }
        }
    }

    fun clearInput(view: View) {
        with(binding) {
            operand1 = 0.0
            operator = ""
            operand2 = 0.0
            viewResult.text = ""
        }
    }

    fun hapusInput(view: View) {
        with(binding) {
            if (operator.isEmpty()) {
                operand1 = operand1 / 10
                viewResult.text = operand1.toString()
            } else {
                operand2 = operand2 / 10
                viewResult.text = operand2.toString()
            }
        }
    }

    fun hitungHasil(view: View) {
        with(binding) {
            when (operator) {
                "+" -> {
                    val hasil = operand1 + operand2
                    viewResult.text = hasil.toString()
                }
                "-" -> {
                    val hasil = operand1 - operand2
                    viewResult.text = hasil.toString()
                }
                "×" -> {
                    val hasil = operand1 * operand2
                    viewResult.text = hasil.toString()
                }
                "÷" -> {
                    if (operand2 != 0.0) {
                        val hasil = operand1 / operand2
                        viewResult.text = hasil.toString()
                    } else {
                        viewResult.text = "Error"
                    }
                }
            }
        }
    }
}
