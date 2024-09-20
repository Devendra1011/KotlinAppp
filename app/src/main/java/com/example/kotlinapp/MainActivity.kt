package com.example.kotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
lateinit var editText:EditText
lateinit var btn:Button
lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // set the content view of an activity to a specified layout
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initializing the widgets
        editText = findViewById(R.id.edit_text)
        btn = findViewById(R.id.btn_convert)
        textView = findViewById(R.id.tv_result)

        btn.setOnClickListener{
            // code to be executed when the button is clicked
            val enteredUSD:String = editText.text.toString()
            var enterUSDDouble:Double = enteredUSD.toDouble()
            var convertedEuros = makeConversion(enterUSDDouble)
            textView.text = "${convertedEuros}Euros"
        }
    }
    fun makeConversion(usd:Double):Double{
        var euros: Double = usd*0.94
        return euros
    }
}