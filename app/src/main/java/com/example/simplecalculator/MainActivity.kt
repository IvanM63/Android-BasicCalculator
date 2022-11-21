package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.simplecalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var isNewOP = true
    var op = ""
    var prevNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun resultEvent(view: View) {
        var result = 0.0
        var newNumber = binding.editResult.text.toString()

        when(op) {
            "+" -> {result = prevNumber.toDouble() + newNumber.toDouble()}
            "-" -> {result = prevNumber.toDouble() - newNumber.toDouble()}
            "x" -> {result = prevNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = prevNumber.toDouble() / newNumber.toDouble()}
            "^" -> {result = prevNumber.toDouble().pow(2)}
        }

        binding.editResult.setText(result.toString())

    }

    fun numberPress(view: View) {
        if(isNewOP == true) {
            binding.editResult.setText("")
        }
        isNewOP = false
        var tempResult = binding.editResult.text.toString()
        when(view.id) {
            binding.button1.id -> {tempResult += "1"}
            binding.button2.id -> {tempResult += "2"}
            binding.button3.id -> {tempResult += "3"}
            binding.button4.id -> {tempResult += "4"}
            binding.button5.id -> {tempResult += "5"}
            binding.button6.id -> {tempResult += "6"}
            binding.button7.id -> {tempResult += "7"}
            binding.button8.id -> {tempResult += "8"}
            binding.button9.id -> {tempResult += "9"}
            binding.button0.id -> {tempResult += "0"}
            binding.buttonComa.id -> {
                tempResult += "."
            }
        }

        binding.editResult.setText(tempResult)

    }

    fun operationEvent(view: View) {
        isNewOP = true
        prevNumber = binding.editResult.text.toString()
        when(view.id) {
            binding.buttonPlus.id -> {op = "+"}
            binding.buttonMinus.id -> {op = "-"}
            binding.buttonTimes.id -> {op = "x"}
            binding.buttonDivide.id -> {op = "/"}
            binding.buttonSquare.id -> {
                op = "^"
                resultEvent(view)
            }
        }
    }

    fun eventAC(view: View) {
        isNewOP = true
        binding.editResult.setText("0")
    }

    fun eventDEL(view: View) {
        var temp = binding.editResult.text.toString()
        var result = ""

        if (temp.length == 1) {
            result = "0"
            isNewOP = true
        } else {
            result = temp.dropLast(1)
        }


        binding.editResult.setText(result)
    }


}