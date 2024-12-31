package com.onuryasarkaraduman.core.domain.model

import androidx.annotation.StringRes
import com.onuryasarkaraduman.core.R

enum class UserCategory(
    @StringRes val displayName: Int,
    val imageResource: Int,
    val value: String,
) {
    TECHNOLOGY(
        displayName = R.string.technology,
        imageResource = R.drawable.technology,
        value = "technology"
    ),
    SPORTS(
        displayName = R.string.sports,
        imageResource = R.drawable.sports,
        value = "sports"
    ),
    HEALTH(
        displayName = R.string.health,
        imageResource = R.drawable.health,
        value = "health"
    ),
    MUSIC(
        displayName = R.string.music,
        imageResource = R.drawable.music,
        value = "music"
    ),
    ART(
        displayName = R.string.art,
        imageResource = R.drawable.art,
        value = "art"
    ),
    TRAVEL(
        displayName = R.string.travel,
        imageResource = R.drawable.travel,
        value = "travel"
    ),
    FOOD(
        displayName = R.string.food,
        imageResource = R.drawable.food,
        value = "food"
    ),
    FICTION(
        displayName = R.string.fiction,
        imageResource = R.drawable.fiction,
        value = "fiction"
    ),
    SCIENCE(
        displayName = R.string.science,
        imageResource = R.drawable.science,
        value = "science"
    ),
    FANTASY(
        displayName = R.string.fantasy,
        imageResource = R.drawable.fantasy,
        value = "fantasy"
    ),
    MYSTERY(
        displayName = R.string.mystery,
        imageResource = R.drawable.mystery,
        value = "mystery"
    ),
    BIOGRAPHY(
        displayName = R.string.biography,
        imageResource = R.drawable.biography,
        value = "biography"
    ),
    SELF_HELP(
        displayName = R.string.self_help,
        imageResource = R.drawable.self_help,
        value = "self_help"
    ),
    HISTORY(
        displayName = R.string.history,
        imageResource = R.drawable.history,
        value = "history"
    )
}

