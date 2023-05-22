package com.aold.timeplanner.domain.common

import com.aold.core.utils.handlers.ErrorHandler
import javax.inject.Inject

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface MainErrorHandler : ErrorHandler<MainFailures> {

    class Base @Inject constructor() : MainErrorHandler {
        override fun handle(throwable: Throwable) = when (throwable) {
            else -> MainFailures.OtherError(throwable)
        }
    }
}
