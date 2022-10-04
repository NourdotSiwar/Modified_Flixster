package com.example.modifiedflixster

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MoviesAdapter"

class MoviesAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder
        val movie = movies[position]
       holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val movieImageView = itemView.findViewById<ImageView>(R.id.movieImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.movieTitle)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(movie: Movie) {
            titleTextView.text = movie.title

            val radius = 50; // corner radius, higher value = more rounded

            Glide.with(context)
                .load(movie.mediaImageUrl)
                .centerCrop() // scale image to fill the entire ImageView
                .transform(RoundedCorners(radius))
                .into(movieImageView)
        }


        override fun onClick(v: View?) {
            val movie = movies[absoluteAdapterPosition]

            //  Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }
    }
}