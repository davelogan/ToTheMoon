package com.wt.hackathon.tothemoon.domain


sealed class Question {
    class YesNoQuestion(val id: Int, val question: String, val  correctAnswer: Boolean): Question()
    class ImageSetQuestion(val id: Int, val question: String, val answer: List<Answer>): Question()
}
