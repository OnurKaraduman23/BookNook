package com.onuryasarkaraduman.core.data.preferences

import android.content.SharedPreferences
import com.onuryasarkaraduman.core.domain.preferences.Preferences
import com.onuryasarkaraduman.core.domain.preferences.Preferences.Companion.KEY_USER_CATEGORIES

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
): Preferences {
    override fun saveCategories(categories: Set<String>) {
        sharedPreferences.edit()
            .putStringSet(KEY_USER_CATEGORIES, categories)
            .apply()

    }

    override fun getCategories(): Set<String> {
        return sharedPreferences.getStringSet(KEY_USER_CATEGORIES,emptySet()) ?: emptySet()
    }
}