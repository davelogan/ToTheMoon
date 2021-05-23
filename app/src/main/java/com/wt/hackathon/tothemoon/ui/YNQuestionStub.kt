package com.wt.hackathon.tothemoon.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wt.hackathon.tothemoon.domain.YesNoQuestion
import com.wt.hackathon.tothemoon.ui.theme.ToTheMoonTheme


@Composable
fun YesNoQuestionStub(
    question: YesNoQuestion,
    onResult: (result: Boolean) -> Unit
) {
    ToTheMoonTheme {
        Surface() {
            Column() {
                Text(
                    text = question.question
                )
                Button(onClick = { onResult(true) }) {
                    Text(text = "Yes")
                }
                Button(onClick = { onResult(false) }) {
                    Text(text = "No, I am a goat")
                }
            }
        }

    }
}