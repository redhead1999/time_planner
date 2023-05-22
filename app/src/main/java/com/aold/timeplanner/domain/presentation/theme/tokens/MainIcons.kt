package com.aold.timeplanner.domain.presentation.theme.tokens

import com.aold.timeplanner.R

/**
 * @author Kirilin Yury on 22.05.2023.
 */
data class MainIcons(
    val launcher: Int,
)

val baseMainIcons = MainIcons(
    launcher = com.google.android.material.R.drawable.material_ic_calendar_black_24dp
)