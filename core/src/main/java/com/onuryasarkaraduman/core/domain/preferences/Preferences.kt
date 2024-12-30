package com.onuryasarkaraduman.core.domain.preferences

interface Preferences {
    fun saveCategories(categories: Set<String>)

    fun getCategories(): Set<String>


    companion object {
        const val KEY_USER_CATEGORIES = "userCategories"
    }
}
