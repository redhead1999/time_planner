package com.aold.timeplanner.domain.common

import kotlinx.parcelize.Parcelize
import com.aold.core.utils.functional.DomainFailures

/**
 * @author Kirilin Yury on 22.05.2023.
 */
@Parcelize
sealed class MainFailures : DomainFailures {
    data class OtherError(val throwable: Throwable) : MainFailures()
}