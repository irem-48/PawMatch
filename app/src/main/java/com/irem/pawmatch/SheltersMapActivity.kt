package com.irem.pawmatch

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SheltersMapActivity : AppCompatActivity() {

    private lateinit var webMap: WebView

    private fun loadMap(latitude: Double, longitude: Double) {
        val html = """
        <html>
        <body style="margin:0;padding:0;">
            <iframe 
                width="100%" 
                height="100%" 
                frameborder="0" 
                scrolling="no" 
                src="https://www.openstreetmap.org/export/embed.html?bbox=${longitude - 0.01},${latitude - 0.01},${longitude + 0.01},${latitude + 0.01}&layer=mapnik&marker=$latitude,$longitude">
            </iframe>
        </body>
        </html>
    """.trimIndent()

        webMap.loadDataWithBaseURL(
            "https://www.openstreetmap.org",
            html,
            "text/html",
            "UTF-8",
            null
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shelters_map)

        webMap = findViewById(R.id.webMap)

        webMap.webViewClient = WebViewClient()
        webMap.settings.javaScriptEnabled = true
        webMap.settings.domStorageEnabled = true

        val btnManisaShelter = findViewById<Button>(R.id.btnManisaShelter)
        val btnIzmirShelter = findViewById<Button>(R.id.btnIzmirShelter)
        val btnMuglaShelter = findViewById<Button>(R.id.btnMuglaShelter)

        loadMap(38.6191, 27.4289)

        btnManisaShelter.setOnClickListener {
            loadMap(38.6191, 27.4289)
        }

        btnIzmirShelter.setOnClickListener {
            loadMap(38.4237, 27.1428)
        }

        btnMuglaShelter.setOnClickListener {
            loadMap(37.2153, 28.3636)
        }
    }
}