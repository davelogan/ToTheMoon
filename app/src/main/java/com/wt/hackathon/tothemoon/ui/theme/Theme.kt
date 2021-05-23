package com.wt.hackathon.tothemoon.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ToTheMoonTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    MaterialTheme(
        //colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        colors = DarkColorPalette,
        typography = JetnewsTypography,
        shapes = Shapes,
        content = content
    )
}