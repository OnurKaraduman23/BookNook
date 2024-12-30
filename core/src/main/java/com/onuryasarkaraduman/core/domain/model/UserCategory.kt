package com.onuryasarkaraduman.core.domain.model

import androidx.annotation.StringRes
import com.onuryasarkaraduman.core.R

enum class UserCategory(
    @StringRes val displayName: Int,
    val imageResource: Int,
) {
    TECHNOLOGY(R.string.technology, R.drawable.technology),
    SPORTS(R.string.sports, R.drawable.sports),
    HEALTH(R.string.health, R.drawable.health),
    MUSIC(R.string.music, R.drawable.music),
    ART(R.string.art, R.drawable.art),
    TRAVEL(R.string.travel, R.drawable.travel),
    FOOD(R.string.food, R.drawable.food),
    FICTION(R.string.fiction, R.drawable.fiction),
    SCIENCE(R.string.science, R.drawable.science),
    FANTASY(R.string.fantasy, R.drawable.fantasy),
    MYSTERY(R.string.mystery, R.drawable.mystery),
    BIOGRAPHY(R.string.biography, R.drawable.biography),
    SELF_HELP(R.string.self_help, R.drawable.self_help),
    HISTORY(R.string.history, R.drawable.history)
}

