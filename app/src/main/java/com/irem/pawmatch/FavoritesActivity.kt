package com.irem.pawmatch

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FavoritesActivity : AppCompatActivity() {

    private lateinit var listFavorites: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        listFavorites = findViewById(R.id.listFavorites)

        val sharedPreferences = getSharedPreferences("PawMatchPrefs", MODE_PRIVATE)
        val favorites = sharedPreferences.getStringSet("favorites", emptySet())?.toList() ?: emptyList()

        if (favorites.isEmpty()) {
            Toast.makeText(this, "No favorite pets yet", Toast.LENGTH_SHORT).show()
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            favorites
        )

        listFavorites.adapter = adapter
    }
}