package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val artistRes: Int,
    @StringRes val yearRes: Int,
    @StringRes val imageDescriptionRes: Int,
)
