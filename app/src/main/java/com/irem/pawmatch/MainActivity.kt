package com.irem.pawmatch

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var edtUserName: EditText
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUserName = findViewById(R.id.edtUserName)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            val userName = edtUserName.text.toString().trim()

            if (userName.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("PawMatchPrefs", MODE_PRIVATE)

                sharedPreferences.edit()
                    .putString("userName", userName)
                    .apply()

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("userName", userName)
                startActivity(intent)
            }
        }
    }
}