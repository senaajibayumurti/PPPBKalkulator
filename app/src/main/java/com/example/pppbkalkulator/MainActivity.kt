// MainActivity.kt
package com.example.pppbkalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.pppbkalkulator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var bil1: Double = 0.0
    private var bil2: Double = 0.0
    private var viewOperator: String = ""
    private var nilaiHasil: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun inputNilai(view: View) {
        with(binding) {
            when((view as Button).text.toString()){
                "1" ->{
                    inputAngka("1")
                }
                "2" ->{
                    inputAngka("2")
                }
                "3" ->{
                    inputAngka("3")
                }
                "4" ->{
                    inputAngka("4")
                }
                "5" ->{
                    inputAngka("5")
                }
                "6" ->{
                    inputAngka("6")
                }
                "7" ->{
                    inputAngka("7")
                }
                "8" ->{
                    inputAngka("8")
                }
                "9" ->{
                    inputAngka("9")
                }
                "0" ->{
                    inputAngka("0")
                }

            }
        }
    }

    fun clearInput(view: View) {
        with(binding) {
            firstNum.text = ""
            secondNum.text = ""
            bil1 = 0.0
            bil2 = 0.0
            viewResult.text = ""
            operator.text= ""
            viewOperator=""
        }
    }

    //=
    fun hasil(view: View){
        with(binding){
            when(viewOperator){
                "+" -> {
                    nilaiHasil= (bil1 + bil2).roundToInt()
                    viewResult.text= nilaiHasil.toString()
                }
                "-" -> {
                    nilaiHasil= (bil1 - bil2).roundToInt()
                    viewResult.text= nilaiHasil.toString()
                }
                "×" -> {
                    nilaiHasil= (bil1 * bil2).roundToInt()
                    viewResult.text= nilaiHasil.toString()
                }
                "÷" -> {
                    nilaiHasil= (bil1 / bil2).roundToInt()
                    viewResult.text= nilaiHasil.toString()
                }
            }
        }
    }

    //+, -, /, *
    fun inputOperator(view: View) {
        with(binding) {
            when((view as Button).text.toString()){
                "+" ->{
                    operator.text="+"
                    viewOperator="+"
                }
                "-" ->{
                    operator.text="-"
                    viewOperator="-"
                }
                "×" ->{
                    operator.text="×"
                    viewOperator="×"
                }
                "÷" ->{
                    operator.text="÷"
                    viewOperator="÷"
                }

            }
        }
    }

    fun inputAngka(x: String){
        with(binding){
            if (viewOperator.isEmpty()){
                firstNum.text = firstNum.text.toString() + x
                bil1 = firstNum.text.toString().toInt().toDouble()
            }
            else{
                secondNum.text = secondNum.text.toString() + x
                bil2 = secondNum.text.toString().toInt().toDouble()
            }
        }
    }


}
