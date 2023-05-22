package com.aold.core.utils.functional

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface Mapper<I, O> {
    fun map(input: I): O
}

interface ParameterizedMapper<I, O, P> {
    fun map(input: I, parameter: P): O
}
