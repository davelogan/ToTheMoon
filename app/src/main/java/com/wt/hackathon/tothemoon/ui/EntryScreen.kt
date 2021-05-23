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
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wt.hackathon.tothemoon.R
import com.wt.hackathon.tothemoon.domain.Answer
import com.wt.hackathon.tothemoon.domain.Question
import com.wt.hackathon.tothemoon.domain.Quiz
import com.wt.hackathon.tothemoon.ui.theme.*


/**
 * Shows the entire screen.
 */
@ExperimentalFoundationApi
@Composable
fun EntryScreen(
//    question: Question.ImageSetQuestion,
//    onCaptchaResult: (result: Boolean) -> Unit
) {
    var didRequest by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonStart()
        Spacer(Modifier.height(32.dp))
        MiniCaptcha()
    }
}

@Composable
fun ButtonStart() {
    Button(
        onClick = { },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = green300,
            contentColor = Color.White
        ),
    ) {
        Text("Request Permission to Re-enter Society",
                modifier = Modifier.padding(all = 20.dp)
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun MiniCaptcha() {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(5.dp))
            .background(grey100)
            .border(width = 1.dp, color=grey200)
            .padding(16.dp),

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(35.dp, 35.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(Color.White)
                    .border(width = 2.dp, color = grey200)
            )
            Spacer(Modifier.width(8.dp))
            Text("I'm a responsible human", color = grey700)
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_recaptchalogo),
                    contentDescription = null, // decorative element,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )
                Text("Privacy - Terms", color = grey200, fontSize = 10.sp)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun PreviewEntryScreen() {
    ToTheMoonTheme {
        EntryScreen()
    }
}