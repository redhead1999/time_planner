package com.aold.core.utils.wrappers

import com.aold.core.utils.functional.Either
import com.aold.core.utils.handlers.ErrorHandler
import kotlinx.coroutines.flow.*
import com.aold.core.utils.functional.DomainFailures

/**
 * @author Kirilin Yury on 20.05.2023.
 */
interface EitherWrapper<F : DomainFailures> {

    suspend fun <O> wrap(block: suspend () -> O): Either<F, O>

    abstract class Abstract<F : DomainFailures>(
        private val errorHandler: ErrorHandler<F>,
    ) : EitherWrapper<F> {

        override suspend fun <O> wrap(block: suspend () -> O) = try {
            Either.Right(data = block.invoke())
        } catch (error: Throwable) {
            Either.Left(data = errorHandler.handle(error))
        }
    }
}

interface FlowEitherWrapper<F : DomainFailures> : EitherWrapper<F> {

    suspend fun <O> wrapFlow(block: suspend () -> Flow<O>): Flow<Either<F, O>>

    abstract class Abstract<F : DomainFailures>(
        private val errorHandler: ErrorHandler<F>,
    ) : FlowEitherWrapper<F>, EitherWrapper.Abstract<F>(errorHandler) {

        override suspend fun <O> wrapFlow(block: suspend () -> Flow<O>) = flow {
            block.invoke()
                .catch { error -> this@flow.emit(Either.Left(data = errorHandler.handle(error))) }
                .collect { data -> emit(Either.Right(data = data)) }
        }
    }
}
