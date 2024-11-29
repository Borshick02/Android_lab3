package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var buttonOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editTextName = findViewById(R.id.editTextName)
        buttonOk = findViewById(R.id.buttonOk)

        val greeting = intent.getStringExtra("greeting")

        buttonOk.setOnClickListener {
            val name = editTextName.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите имя!", Toast.LENGTH_SHORT).show()
            } else {
                val resultIntent = Intent().apply {
                    putExtra("name", name)
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
