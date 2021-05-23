package com.wt.hackathon.tothemoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.wt.hackathon.tothemoon.domain.Quiz
import com.wt.hackathon.tothemoon.ui.*

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowQuiz(Quiz.allQuestions)
        }
    }
}
