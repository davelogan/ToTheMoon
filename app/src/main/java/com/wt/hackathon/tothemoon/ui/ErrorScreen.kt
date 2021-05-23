package com.wt.hackathon.tothemoon.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.ui.theme.ToTheMoonTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ErrorScreen(showDialog: MutableState<Boolean>, onDone: (Boolean) -> Unit) {

    AnimatedVisibility(
        visible = showDialog.value
    ) {
        ToTheMoonTheme {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "You are not a human"
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()) {
                        Button(onClick = { onDone(true) }) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }
}