package com.example.notas

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt = botao
        val tvMedia = media
        val n1 = nota1
        val n2 = nota2
        bt.setOnClickListener {
            val result = media(n1.text.toString().toDouble(), n2.text.toString().toDouble())
            if(result >= 6) tvMedia.setTextColor(Color.GREEN)
            else tvMedia.setTextColor(Color.RED)
            tvMedia.text = result.toString()
            Log.e("Main", "Conta realizada!");
        }

        n1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.toString().isEmpty()) {
                    n1.setText("")
                }
            }
        })

        n2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.toString().isEmpty()) {
                    n2.setText("")
                }
            }
        })
    }

    private fun media (nota1:Double, nota2:Double): Double = (nota1 + nota2) / 2
}

