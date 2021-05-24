package com.wt.hackathon.tothemoon.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wt.hackathon.tothemoon.R
import com.wt.hackathon.tothemoon.domain.YesNoQuestion
import com.wt.hackathon.tothemoon.ui.theme.ToTheMoonTheme


@Composable
fun YesNoQuestionStub(
    question: YesNoQuestion,
    onResult: (result: Boolean) -> Unit
) {
    ToTheMoonTheme {
        Surface() {
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = question.question,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(32.dp)
                )
                Spacer(Modifier.height(16.dp))
                if(question.yesText != null) {
                    Button(onClick = { onResult(true) }) {
                        Text(text = question.yesText)
                    }
                }
                Spacer(Modifier.height(16.dp))
                if(question.noText != null) {
                    Button(onClick = { onResult(false) }) {
                        Text(text = question.noText)
                    }
                }
            }

            if(question.id != 1) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.empire_logo_2),
                        contentDescription = null, // decorative element,
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp)

                    )
                    Spacer(Modifier.height(64.dp))
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun PreviewYesNoQuestionStub() {
    ToTheMoonTheme {
        YesNoQuestionStub(YesNoQuestion(1, "Request Permission to Reenter Society", "Continue", null, true)) {}
    }
}