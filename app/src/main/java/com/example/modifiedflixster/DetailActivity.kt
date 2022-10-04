package com.example.modifiedflixster
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var movieImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var releaseTextView: TextView
    private lateinit var summaryTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        // TODO: Find the views for the screen

        movieImageView = findViewById(R.id.movieImage)
        titleTextView = findViewById(R.id.movieTitle)
        releaseTextView = findViewById(R.id.movieRelease)
        summaryTextView = findViewById(R.id.movieSummary)

        // Get the extra from the Intent
        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        // Set the title, byline, and abstract information from the article
        titleTextView.text = movie.title
        releaseTextView.text = movie.release
        summaryTextView.text = movie.summary
        // Load the media image

        val radius = 50 // corner radius, higher value = more rounded
        Glide.with(this)
            .load(movie.mediaImageUrl)
            .into(movieImageView)
    }
}

