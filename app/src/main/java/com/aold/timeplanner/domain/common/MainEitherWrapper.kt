package com.aold.timeplanner.domain.common

import com.aold.core.utils.wrappers.FlowEitherWrapper
import javax.inject.Inject

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface MainEitherWrapper : FlowEitherWrapper<MainFailures> {

    class Base @Inject constructor(errorHandler: MainErrorHandler) : MainEitherWrapper,
        FlowEitherWrapper.Abstract<MainFailures>(errorHandler)
}
