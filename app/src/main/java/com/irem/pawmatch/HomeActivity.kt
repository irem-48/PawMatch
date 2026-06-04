package com.irem.pawmatch

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.content.Intent

class HomeActivity : AppCompatActivity() {

    private lateinit var btnCats: Button
    private lateinit var btnDogs: Button
    private lateinit var btnAllPets: Button
    private lateinit var btnFavorites: Button
    private lateinit var btnShelters: Button

    private lateinit var txtWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        txtWelcome = findViewById(R.id.txtWelcome)

        val sharedPreferences = getSharedPreferences("PawMatchPrefs", MODE_PRIVATE)
        val userName = intent.getStringExtra("userName")
            ?: sharedPreferences.getString("userName", "Friend")

        txtWelcome.text = "Welcome, $userName 🐾"

        btnCats = findViewById(R.id.btnCats)
        btnDogs = findViewById(R.id.btnDogs)
        btnAllPets = findViewById(R.id.btnAllPets)
        btnFavorites = findViewById(R.id.btnFavorites)
        btnShelters = findViewById(R.id.btnShelters)

        btnCats.setOnClickListener {
            val intent = Intent(this, PetListActivity::class.java)
            intent.putExtra("FILTER", "Cat")
            startActivity(intent)
        }

        btnDogs.setOnClickListener {
            val intent = Intent(this, PetListActivity::class.java)
            intent.putExtra("FILTER", "Dog")
            startActivity(intent)
        }

        btnAllPets.setOnClickListener {
            val intent = Intent(this, PetListActivity::class.java)
            intent.putExtra("FILTER", "All")
            startActivity(intent)
        }

        btnFavorites.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }

        btnShelters.setOnClickListener {
            val intent = Intent(this, SheltersMapActivity::class.java)
            startActivity(intent)
        }
    }
}