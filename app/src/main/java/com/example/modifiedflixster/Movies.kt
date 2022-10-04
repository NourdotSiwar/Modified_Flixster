package com.example.modifiedflixster
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("results")
    val results: List<Movie>?
)

@Keep
@Serializable
data class Movie(
    @SerialName("original_title")
    val title: String?,
    @SerialName("overview")
    val summary: String?,
    @SerialName("release_date")
    val release: String?,
    @SerialName("poster_path")
    val image: String?,
): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500/${image}"
}