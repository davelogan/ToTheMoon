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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.domain.ImageSetQuestion
import com.wt.hackathon.tothemoon.domain.Question
import com.wt.hackathon.tothemoon.domain.YesNoQuestion
import com.wt.hackathon.tothemoon.ui.theme.ToTheMoonTheme

@ExperimentalFoundationApi
@Composable
fun ShowQuiz(allQuestions: List<Question>) {
    ToTheMoonTheme {
        Surface {
            val visibleIndex = remember { mutableStateOf(0) }
            val indexAfterError = remember { mutableStateOf(0) }
            val showError = remember { mutableStateOf(false) }
            val screens = remember { mutableListOf<QuestionScreen>() }

            allQuestions.forEachIndexed { i, question ->
                val screen = createQuestionScreen(i,
                    { visibleScreenIndex: Int, isCorrect: Boolean ->
                        if (isCorrect) {
                            if (visibleScreenIndex < allQuestions.size) {
                                visibleIndex.value = visibleScreenIndex + 1
                            }
                        } else {
                            indexAfterError.value = visibleIndex.value
                            visibleIndex.value = -1
                            showError.value = true
                        }
                    },
                    question)
                screens.add(screen)
                QuestionScreenWrapper(i, visibleIndex, screen)
                ErrorScreen(showError) {
                    showError.value = false
                    visibleIndex.value = indexAfterError.value
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun createQuestionScreen(
    index: Int, onNextScreen: (Int, Boolean) -> Unit,
    question: Question
): QuestionScreen {

    return when (question) {
        is YesNoQuestion -> {
            QuestionScreen(body = {
                YesNoQuestionStub(question = question) {
                    onNextScreen(index, it)
                }
            })
        }
        is ImageSetQuestion -> {
            QuestionScreen(
                body = {
                    Captcha(question = question) {
                        onNextScreen(index, it)
                    }
                })
        }
    }
}



@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun QuestionScreenWrapper(index: Int, indexVisible: MutableState<Int>, questionScreen: QuestionScreen?) {

    AnimatedVisibility(
        visible = index == indexVisible.value
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.secondary,
            elevation = 4.dp
        ) {
            questionScreen?.content()
        }
    }
}
