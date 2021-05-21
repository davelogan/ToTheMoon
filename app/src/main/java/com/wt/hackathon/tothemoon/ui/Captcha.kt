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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.domain.Answer
import com.wt.hackathon.tothemoon.domain.Question
import com.wt.hackathon.tothemoon.domain.Quiz
import com.wt.hackathon.tothemoon.ui.theme.*


/**
 * Shows the entire screen.
 */
@ExperimentalFoundationApi
@Composable
fun Captcha(question: Question.ImageSetQuestion) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            Row {
                Header(question.question)
            }

            Row {
                Grid(question.answer.toList())
            }

            Row(
                modifier = Modifier.align(Alignment.End)
            ) {
                ButtonVerify()
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
            Text(question, color = Color.White)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Grid(answers: List<Answer>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {

        items(answers.size) {
            Column(
                modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(answers[it].imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(2.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Composable
fun ButtonVerify() {
    Button(
        onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = blue100,
            contentColor = Color.White
        ),
        modifier = Modifier.padding(16.dp)
    ) {
        Text("VERIFY")
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun PreviewHome() {
    ToTheMoonTheme {
        Captcha(Quiz.q2)
    }
}