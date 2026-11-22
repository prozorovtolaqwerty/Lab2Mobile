package com.example.artspace

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var currentIndex = 0

    private lateinit var artworkImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var artistText: TextView
    private lateinit var yearText: TextView
    private lateinit var previousButton: View
    private lateinit var nextButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        val root = findViewById<View>(R.id.root)
        ViewCompat.setOnApplyWindowInsetsListener(root) { view, windowInsets ->
            val bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            windowInsets
        }
        val controller = WindowCompat.getInsetsController(window, root)
        controller.isAppearanceLightStatusBars = true
        controller.isAppearanceLightNavigationBars = true

        artworkImage = findViewById(R.id.artworkImage)
        titleText = findViewById(R.id.titleText)
        artistText = findViewById(R.id.artistText)
        yearText = findViewById(R.id.yearText)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(STATE_INDEX, 0)
        }
        currentIndex = currentIndex.coerceIn(0, ArtworkRepository.artworks.lastIndex)

        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex -= 1
                showCurrentArtwork()
            }
        }
        nextButton.setOnClickListener {
            if (currentIndex < ArtworkRepository.artworks.lastIndex) {
                currentIndex += 1
                showCurrentArtwork()
            }
        }
        showCurrentArtwork()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_INDEX, currentIndex)
    }

    private fun showCurrentArtwork() {
        val artwork = ArtworkRepository.artworks[currentIndex]
        artworkImage.setImageResource(artwork.imageRes)
        artworkImage.contentDescription = getString(artwork.imageDescriptionRes)
        titleText.setText(artwork.titleRes)
        artistText.setText(artwork.artistRes)
        yearText.setText(artwork.yearRes)
        previousButton.isEnabled = currentIndex > 0
        nextButton.isEnabled = currentIndex < ArtworkRepository.artworks.lastIndex
    }

    companion object {
        private const val STATE_INDEX = "current_index"
    }
}
