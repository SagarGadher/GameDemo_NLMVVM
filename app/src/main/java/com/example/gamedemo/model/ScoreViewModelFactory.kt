package com.example.gamedemo.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ScoreViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java))
            return ScoreViewModel(finalScore) as T
        throw IllegalArgumentException("UnKnown ViewModel Class")
    }

}