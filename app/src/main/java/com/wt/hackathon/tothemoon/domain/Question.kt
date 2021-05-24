package com.wt.hackathon.tothemoon.domain

sealed class Question {
    abstract val id: Int
    abstract val question: String
}

data class YesNoQuestion(override val id: Int, override val question: String, val yesText: String?, val noText: String?, val correctAnswer: Boolean): Question()
data class SimpleCaptcha(override val id: Int, override val question: String): Question()
data class ImageSetQuestion(override val id: Int, override val question: String, val answers: List<Answer>): Question()

