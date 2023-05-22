package com.aold.core.utils.functional

/**
 * @author Kirilin Yury on 22.05.2023.
 */
sealed class ResponseResult<out T> {

    abstract fun <O> map(dataTransform: (T) -> O): ResponseResult<O>

    sealed class Success<T> : ResponseResult<T>() {

        abstract val data: T?

        abstract val code: Int

        data class Data<T>(override val data: T, override val code: Int) : Success<T>() {
            override fun <O> map(dataTransform: (T) -> O) = Data(dataTransform.invoke(data), code)
        }

        data class Empty<T>(override val data: T?, override val code: Int) : Success<T>() {
            override fun <O> map(dataTransform: (T) -> O) = Empty<O>(null, code)
        }
    }

    data class Error(val throwable: Throwable) : ResponseResult<Nothing>() {
        override fun <O> map(dataTransform: (Nothing) -> O) = this
    }
}

fun <T> ResponseResult<T>.dataOrThrow(): T? = when (this) {
    is ResponseResult.Success.Data -> data
    is ResponseResult.Success.Empty -> null
    is ResponseResult.Error -> throw throwable
}

fun <T> ResponseResult<T>.codeOrThrow(): Int = when (this) {
    is ResponseResult.Success.Data -> code
    is ResponseResult.Success.Empty -> code
    is ResponseResult.Error -> throw throwable
}
