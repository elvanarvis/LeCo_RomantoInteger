package com.simtrayclub.leco_romantointeger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        romanToInt("MMXLIV")

    }

    fun romanToInt(s: String): Int {
        var result = 0

        if(s.isEmpty()){

            println("Please enter a roman numeral!")

        }else{
        }

        for(i in s.indices) {
            val char = s[i]
            val current = char.number()
            result += current
            if(i==0) continue

            val ch_previous = s[i-1]
            val previous = s[i-1].number()
            if(previous < current) {
                result -= previous
                result -= current
                val secondchar = char.toString()
                val firstchar = ch_previous.toString()
                val _numString = firstchar+secondchar
                val numString = _numString.num()
                result += numString
            }
        }

        controlResult(result)

        println(result)
        return result
    }

    private fun controlResult(result: Int): Int {
        var result = result
        if(result>3999){
            result = 0
            println("The number bigger than 3999")
        }
        return result
    }

    private fun String.num() : Int{
        return when(this) {
            "IV" -> 4
            "IX" -> 9
            "XL" -> 40
            "XC" -> 90
            "CD" -> 400
            "CM" -> 900
            else -> 0
        }
    }

    private fun Char.number() : Int{
        return when(this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }


}