package com.wt.hackathon.tothemoon.domain

sealed class Question {
    abstract val id: Int
    abstract val question: String
}

data class YesNoQuestion(override val id: Int, override val question: String, val correctAnswer: Boolean): Question()
data class ImageSetQuestion(override val id: Int, override val question: String, val answers: List<Answer>): Question()

