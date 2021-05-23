package com.wt.hackathon.tothemoon.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wt.hackathon.tothemoon.domain.Question

class QuizViewModel() : ViewModel() {

    private var currentQuestionIndex by mutableStateOf(0)

    var questions by mutableStateOf(listOf<Question>())
        private set

    val currentCurrentQuestion: Question?
        get() = questions.getOrNull(currentQuestionIndex)

    fun load(allQuestions: List<Question>) {
        questions = allQuestions.toMutableList()
    }

    fun onShowingQuestion(question: Question) {
        currentQuestionIndex = questions.indexOf(question)
    }

    fun getNextQuestion() : Question? {
        val nextIndex = questions.indexOf(currentCurrentQuestion)
        return if (nextIndex < questions.size) {
            questions[nextIndex]
        } else {
            null
        }
    }
}