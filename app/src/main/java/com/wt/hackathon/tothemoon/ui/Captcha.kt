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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.R
import com.wt.hackathon.tothemoon.ui.theme.*


/**
 * Shows the entire screen.
 */
@ExperimentalFoundationApi
@Composable
fun Captcha() {
    Column {
        Row {
            Header()
        }

        Row {
            Grid()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(blue100).fillMaxWidth().padding(16.dp),
    ) {
        Column {
            Text("photographer.name")
            Text("photographer.lastSeenOnline, ...")
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Grid() {
    val numbers = (1..9).toList()

    return LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {
        items(numbers.size) {
            Column(
                modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(2.dp)),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun PreviewHome() {
    ToTheMoonTheme {
        Captcha()
    }
}