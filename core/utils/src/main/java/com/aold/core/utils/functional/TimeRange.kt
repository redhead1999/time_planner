package com.aold.core.utils.functional

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Parcelize
data class TimeRange(val from: Date, val to: Date) : Parcelable
