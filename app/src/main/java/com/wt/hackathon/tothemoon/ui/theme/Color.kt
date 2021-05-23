package com.wt.hackathon.tothemoon.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors

val white100 = Color(0xFFFFF9FA)
val white200 = Color(0xFFFFEFEF)

val yellow100 = Color(0xFFFFEB3B)
val yellow700 = Color(0xFFBBA801)

val amber600 = Color(0xFFFFB300)

val purple100 = Color(0xFFE1BEE7)
val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)

val teal200 = Color(0xFF03DAC5)

val red200 = Color(0xfff297a2)
val red300 = Color(0xffea6d7e)
val red700 = Color(0xffdd0d3c)
val red800 = Color(0xffd00036)
val red900 = Color(0xFF91001F)

val green300 = Color(0xFF81C784)
val green500 = Color(0xFF2E7D32)
val green800 = Color(0xFF015005)

val blue100 = Color(0xFF2741EC)
val blue200 = Color(0xFF092FFF)
val blue500 = Color(0xFF001DBD)
val blue700 = Color(0xFF010C44)

val grey100 = Color(0xFFD9D9DA)
val grey200 = Color(0xFFA9A9AA)
val grey500 = Color(0xFF5D5D5E)
val grey700 = Color(0xFF2F2F30)

val black900 = Color(0x00000000)

val DarkColorPalette = darkColors(
    primary = yellow700,
    primaryVariant = Color.Black,
    onPrimary = Color.Black,
    secondary = red300,
    onSecondary = Color.Black,
    error = red200
)


val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Color.Black,
    secondary = yellow700,
    background = Color.Black,
    surface = Color.Black,
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)