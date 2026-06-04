package com.irem.pawmatch

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

class AdoptionFormActivity : AppCompatActivity() {
    private fun showAdoptionNotification(petName: String) {
        val channelId = "adoption_channel"

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Adoption Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("PawMatch")
            .setContentText("Your adoption application for $petName has been submitted 🐾")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(1, notification)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption_form)

        val txtSelectedPet = findViewById<TextView>(R.id.txtSelectedPet)
        val edtFullName = findViewById<EditText>(R.id.edtFullName)
        val edtPhone = findViewById<EditText>(R.id.edtPhone)
        val edtCity = findViewById<EditText>(R.id.edtCity)
        val spinnerHomeType = findViewById<Spinner>(R.id.spinnerHomeType)
        val checkExperience = findViewById<CheckBox>(R.id.checkExperience)
        val btnSubmitApplication = findViewById<Button>(R.id.btnSubmitApplication)

        val petName = intent.getStringExtra("petName") ?: "Selected Pet"
        txtSelectedPet.text = "Application for: $petName"

        val homeTypes = listOf("Apartment", "House with garden", "Farm", "Other")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            homeTypes
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHomeType.adapter = adapter

        btnSubmitApplication.setOnClickListener {
            val fullName = edtFullName.text.toString().trim()
            val phone = edtPhone.text.toString().trim()
            val city = edtCity.text.toString().trim()
            val homeType = spinnerHomeType.selectedItem.toString()
            val hasExperience = checkExperience.isChecked

            if (fullName.isEmpty() || phone.isEmpty() || city.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("PawMatchPrefs", MODE_PRIVATE)

                sharedPreferences.edit()
                    .putString("lastApplicationPet", petName)
                    .putString("lastApplicationName", fullName)
                    .putString("lastApplicationPhone", phone)
                    .putString("lastApplicationCity", city)
                    .putString("lastApplicationHomeType", homeType)
                    .putBoolean("lastApplicationExperience", hasExperience)
                    .apply()

                Toast.makeText(
                    this,
                    "Application submitted for $petName 🐾",
                    Toast.LENGTH_LONG
                ).show()

                showAdoptionNotification(petName)
            }
        }
    }
}