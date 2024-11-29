package com.example.kotlinproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1
    private lateinit var greetingTextView: TextView
    private lateinit var editTextGreeting: EditText
    private lateinit var button: Button
    private var greeting: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetingTextView = findViewById(R.id.greetingTextView)
        editTextGreeting = findViewById(R.id.editTextGreeting)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            greeting = editTextGreeting.text.toString().trim()

            if (greeting.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите приветствие!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("greeting", greeting)
                }
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val name = data?.getStringExtra("name")
            val fullGreeting = "$greeting, $name!"
            greetingTextView.text = fullGreeting
        }
    }
}
