package com.irem.pawmatch

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)

        val txtPetName = findViewById<TextView>(R.id.txtPetName)
        val txtPetType = findViewById<TextView>(R.id.txtPetType)
        val txtPetAge = findViewById<TextView>(R.id.txtPetAge)
        val txtPetCity = findViewById<TextView>(R.id.txtPetCity)
        val txtPetDescription = findViewById<TextView>(R.id.txtPetDescription)
        val btnAddFavorite = findViewById<Button>(R.id.btnAddFavorite)
        val imgPet = findViewById<ImageView>(R.id.imgPet)
        val btnApplyAdoption = findViewById<Button>(R.id.btnApplyAdoption)

        txtPetName.text = intent.getStringExtra("name")
        txtPetType.text = "Type: " + intent.getStringExtra("type")
        txtPetAge.text = "Age: " + intent.getStringExtra("age")
        txtPetCity.text = "City: " + intent.getStringExtra("city")
        txtPetDescription.text = intent.getStringExtra("description")
        val petType = intent.getStringExtra("type") ?: ""

        if (petType == "Cat") {
            RetrofitClient.catApi.getRandomCatImage().enqueue(object : Callback<List<CatImageResponse>> {
                override fun onResponse(
                    call: Call<List<CatImageResponse>>,
                    response: Response<List<CatImageResponse>>
                ) {
                    val imageUrl = response.body()?.firstOrNull()?.url

                    if (!imageUrl.isNullOrEmpty()) {
                        Glide.with(this@PetDetailActivity)
                            .load(imageUrl)
                            .into(imgPet)
                    }
                }

                override fun onFailure(call: Call<List<CatImageResponse>>, t: Throwable) {
                    Toast.makeText(this@PetDetailActivity, "Cat image could not be loaded", Toast.LENGTH_SHORT).show()
                }
            })
        } else if (petType == "Dog") {
            RetrofitClient.dogApi.getRandomDogImage().enqueue(object : Callback<DogImageResponse> {
                override fun onResponse(
                    call: Call<DogImageResponse>,
                    response: Response<DogImageResponse>
                ) {
                    val imageUrl = response.body()?.message

                    if (!imageUrl.isNullOrEmpty()) {
                        Glide.with(this@PetDetailActivity)
                            .load(imageUrl)
                            .into(imgPet)
                    }
                }

                override fun onFailure(call: Call<DogImageResponse>, t: Throwable) {
                    Toast.makeText(this@PetDetailActivity, "Dog image could not be loaded", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btnAddFavorite.setOnClickListener {
            val petName = intent.getStringExtra("name") ?: "Unknown Pet"

            val sharedPreferences = getSharedPreferences("PawMatchPrefs", MODE_PRIVATE)
            val favorites = sharedPreferences.getStringSet("favorites", mutableSetOf())?.toMutableSet()
                ?: mutableSetOf()

            favorites.add(petName)

            sharedPreferences.edit()
                .putStringSet("favorites", favorites)
                .apply()

            Toast.makeText(
                this,
                "$petName added to favorites ❤️",
                Toast.LENGTH_SHORT
            ).show()
        }
        btnApplyAdoption.setOnClickListener {
            val petName = intent.getStringExtra("name") ?: "Selected Pet"

            val intent = Intent(this, AdoptionFormActivity::class.java)
            intent.putExtra("petName", petName)
            startActivity(intent)
        }
    }
}