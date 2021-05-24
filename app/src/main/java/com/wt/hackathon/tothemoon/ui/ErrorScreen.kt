package com.wt.hackathon.tothemoon.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.ui.theme.ToTheMoonTheme
import com.wt.hackathon.tothemoon.ui.theme.yellow700

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ErrorScreen(showDialog: MutableState<Boolean>, onDone: (Boolean) -> Unit) {

    AnimatedVisibility(
        visible = showDialog.value,
        enter = slideInVertically(
            // Enters by sliding in from offset -fullHeight to 0.
            initialOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing),
        ),
        exit = slideOutVertically(
            // Exits by sliding out from offset 0 to -fullHeight.
            targetOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(durationMillis = 350, easing = FastOutLinearInEasing)
        )
    ) {
        ToTheMoonTheme {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                elevation = 4.dp
            ) {

                val infiniteTransition = rememberInfiniteTransition()
                val alpha by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 1f,
                    // `infiniteRepeatable` repeats the specified duration-based `AnimationSpec` infinitely.
                    animationSpec = infiniteRepeatable(
                        // The `keyframes` animates the value by specifying multiple timestamps.
                        animation = keyframes {
                            // One iteration is 1250 milliseconds.
                            durationMillis = 1250
                            // 0.7f at the middle of an iteration.
                            0.7f at 500
                        },
                        // When the value finishes animating from 0f to 1f, it repeats by reversing the
                        // animation direction.
                        repeatMode = RepeatMode.Reverse
                    )
                )

                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .padding(32.dp),
                        color = yellow700.copy(alpha = alpha),
                        textAlign = TextAlign.Center,
                        text = "You are not a human!"
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = { onDone(true) }) {
                        Text(
                            modifier = Modifier
                                .padding(5.dp),
                            textAlign = TextAlign.Center,
                            text = "OK"
                        )


                    }
                }
            }
        }
    }
}