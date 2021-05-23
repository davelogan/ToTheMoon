package com.wt.hackathon.tothemoon.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wt.hackathon.tothemoon.domain.YesNoQuestion


@Composable
fun YesNoQuestionStub(
    question: YesNoQuestion,
    onResult: (result: Boolean) -> Unit
) {
    Column() {
        Text(
            text = question.question
        )
        Button(onClick = { onResult(true)  } ) {
            Text(text = "Yes")
        }
        Button(onClick = {  }) {
            Text(text = "No, I am a goat")
        }
    }
}