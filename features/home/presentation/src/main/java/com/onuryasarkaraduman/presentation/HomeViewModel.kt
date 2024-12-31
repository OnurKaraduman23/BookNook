package com.onuryasarkaraduman.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.onuryasarkaraduman.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferences: Preferences,
) : ViewModel() {

    init {
        loadCategories()
    }

    fun loadCategories() {
        val categories = preferences.getCategories()
        Log.e("Dante", categories.toString())
    }
}