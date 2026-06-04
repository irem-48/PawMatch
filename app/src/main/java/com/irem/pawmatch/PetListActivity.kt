package com.irem.pawmatch

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class PetListActivity : AppCompatActivity() {

    private lateinit var listPets: ListView

    private val pets = listOf(
        Pet(
            "Atlas",
            "Cat",
            "2 years old",
            "Manisa",
            "A calm and curious cat who loves watching outside.",
            ""
        ),
        Pet(
            "Dali",
            "Cat",
            "1 year old",
            "İzmir",
            "A playful cat with a funny personality and lots of energy.",
            ""
        ),
        Pet(
            "Uyku",
            "Cat",
            "3 years old",
            "Muğla",
            "A sleepy and sweet cat who loves quiet homes.",
            ""
        ),
        Pet(
            "Sherlock",
            "Dog",
            "4 years old",
            "Aydın",
            "A smart and loyal dog who enjoys long walks.",
            ""
        ),
        Pet(
            "Watson",
            "Dog",
            "2 years old",
            "Denizli",
            "A friendly dog who loves people and other animals.",
            ""
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_list)

        listPets = findViewById(R.id.listPets)

        val filter = intent.getStringExtra("FILTER") ?: "All"

        val filteredPets = if (filter == "All") {
            pets
        } else {
            pets.filter { it.type == filter }
        }

        val petNames = filteredPets.map { "${it.name} - ${it.type} - ${it.city}" }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            petNames
        )

        listPets.adapter = adapter

        listPets.setOnItemClickListener { _, _, position, _ ->

            val selectedPet = filteredPets[position]

            val intent = Intent(this, PetDetailActivity::class.java)

            intent.putExtra("name", selectedPet.name)
            intent.putExtra("type", selectedPet.type)
            intent.putExtra("age", selectedPet.age)
            intent.putExtra("city", selectedPet.city)
            intent.putExtra("description", selectedPet.description)

            startActivity(intent)
        }
      }
   }

