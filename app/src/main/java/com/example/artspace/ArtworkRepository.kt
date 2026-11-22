package com.example.artspace

object ArtworkRepository {
    val artworks: List<Artwork> = listOf(
        Artwork(
            imageRes = R.drawable.art_creation,
            titleRes = R.string.art_creation_title,
            artistRes = R.string.art_creation_artist,
            yearRes = R.string.art_creation_year,
            imageDescriptionRes = R.string.art_creation_description,
        ),
        Artwork(
            imageRes = R.drawable.art_knight,
            titleRes = R.string.art_knight_title,
            artistRes = R.string.art_knight_artist,
            yearRes = R.string.art_knight_year,
            imageDescriptionRes = R.string.art_knight_description,
        ),
        Artwork(
            imageRes = R.drawable.art_apotheosis,
            titleRes = R.string.art_apotheosis_title,
            artistRes = R.string.art_apotheosis_artist,
            yearRes = R.string.art_apotheosis_year,
            imageDescriptionRes = R.string.art_apotheosis_description,
        ),
        Artwork(
            imageRes = R.drawable.art_morning_forest,
            titleRes = R.string.art_morning_forest_title,
            artistRes = R.string.art_morning_forest_artist,
            yearRes = R.string.art_morning_forest_year,
            imageDescriptionRes = R.string.art_morning_forest_description,
        ),
    )
}
