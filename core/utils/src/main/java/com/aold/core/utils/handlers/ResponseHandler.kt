package com.aold.core.utils.handlers

import com.aold.core.utils.functional.Mapper
import com.aold.core.utils.functional.ResponseResult
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

/**
 * @author Kirilin Yury on 22.05.2023.
 */
interface ResponseHandler {

    suspend fun <T> handle(
        block: suspend () -> Response<T>,
    ): ResponseResult<T>

    suspend fun <T, O> handleWithMap(
        mapper: Mapper<T, O>,
        block: suspend () -> Response<T>,
    ): ResponseResult<O>

    class Base @Inject constructor() : ResponseHandler {

        override suspend fun <T, O> handleWithMap(
            mapper: Mapper<T, O>,
            block: suspend () -> Response<T>,
        ) = handle(block).map { mapper.map(it) }

        override suspend fun <T> handle(
            block: suspend () -> Response<T>,
        ) = try {
            val response = block.invoke()
            if (response.isSuccessful) {
                if (response.body() == null || response.body().toString().isEmpty()) {
                    ResponseResult.Success.Empty(null, response.code())
                } else {
                    ResponseResult.Success.Data(checkNotNull(response.body()), response.code())
                }
            } else {
                ResponseResult.Error(HttpException(response))
            }
        } catch (e: Throwable) {
            ResponseResult.Error(e)
        }
    }
}
