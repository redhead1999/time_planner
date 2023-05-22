package com.aold.core.utils.handlers

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface ErrorHandler<E> {
    fun handle(throwable: Throwable): E
}
