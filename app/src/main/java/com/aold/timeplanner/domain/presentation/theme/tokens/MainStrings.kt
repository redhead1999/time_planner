package com.aold.timeplanner.domain.presentation.theme.tokens

import androidx.compose.runtime.compositionLocalOf

/**
 * @author Kirilin Yury on 22.05.2023.
 */
data class MainStrings(
    val authorTitle: String,
    val launcherIconDesc: String,
)

val splashString = MainStrings(
    authorTitle = "AOLD",
    launcherIconDesc = "Всё идет по плану",
)
