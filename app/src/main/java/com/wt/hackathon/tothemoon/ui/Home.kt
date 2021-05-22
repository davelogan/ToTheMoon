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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import com.wt.hackathon.tothemoon.domain.Quiz
import com.wt.hackathon.tothemoon.ui.theme.ToTheMoonTheme


/**
 * Shows the entire screen.
 */

@ExperimentalFoundationApi
@Composable
fun Home() {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        ShowCaptchaError(showDialog.value)
    }

    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center) {
        Captcha(Quiz.q2) { result ->
            if (result) {
                showDialog.value = false
                goToNextView()
            } else {
                showDialog.value = true
            }
        }
    }
}

private fun goToNextView() {
    // TODO NOT IMPLEMENTED
}

@Composable
private fun ShowCaptchaError(showDialog: Boolean) {
    Error(message = "You are not a human", showDialog = showDialog)
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun PreviewHome() {
    ToTheMoonTheme() {
        Home()
    }
}