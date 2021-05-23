package com.wt.hackathon.tothemoon.ui

import androidx.compose.runtime.Composable

/**
 * Screen metadata for Quiz.
 */
class QuestionScreen(
    val body: @Composable () -> Unit
) {

    @Composable
    fun content() {
        body()
    }
}
