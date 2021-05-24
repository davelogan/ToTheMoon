/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wt.hackathon.tothemoon.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.domain.Answer
import com.wt.hackathon.tothemoon.domain.ImageSetQuestion
import com.wt.hackathon.tothemoon.domain.Quiz
import com.wt.hackathon.tothemoon.ui.theme.*


/**
 * Shows the entire screen.
 */
@ExperimentalFoundationApi
@Composable
fun Captcha(
    question: ImageSetQuestion,
    onCaptchaResult: (result: Boolean) -> Unit
) {
    ToTheMoonTheme {
        val answers = remember { mutableStateOf(question.answers) }

        Surface() {
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    elevation = 10.dp
                ) {
                    Column(
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Row {
                            Header(question.question)
                        }

                        Row {
                            Grid(answers)
                        }

                        Row(
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            ButtonVerify(
                                answers,
                                onCaptchaResult
                            )
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Header(question: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(blue100)
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column {
            Text(question)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Grid(answers: MutableState<List<Answer>>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {
        items(answers.value.size) {
            val isChecked = remember { mutableStateOf(answers.value[it].isChecked) }
            val backgroundColor by animateColorAsState(if (isChecked.value) Color.Red else Color.Transparent)
            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .clickable {
                        answers.value[it].isChecked = !answers.value[it].isChecked
                        isChecked.value = answers.value[it].isChecked
                    }
                    .background(color = backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(answers.value[it].imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(2.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Composable
fun ButtonVerify(answers: MutableState<List<Answer>>, onCaptchaResult: (result: Boolean) -> Unit) {
    Button(
        onClick = {
            validateAnswers(
                answers = answers,
                onCaptchaResult
            )
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("VERIFY")
    }
}

private fun validateAnswers(answers: MutableState<List<Answer>>, onCaptchaResult: (result: Boolean) -> Unit) {
    var valid = true
    answers.value.forEach {
        if (!it.isCorrect()) {
            valid = false
            return@forEach
        }
    }

    if (valid) {
        onCaptchaResult(true)
    } else {
        onCaptchaResult(false)
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun PreviewHome() {
    ToTheMoonTheme {
        Captcha(Quiz.q2) {

        }
    }
}