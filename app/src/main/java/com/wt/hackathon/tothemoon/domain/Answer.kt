package com.wt.hackathon.tothemoon.domain
 class Answer(val id: Int, val imageResourceId: Int, private val correctAnswer: Boolean) {

     var isChecked: Boolean = false

     fun isCorrect() : Boolean {
         return isChecked == correctAnswer
     }
 }
