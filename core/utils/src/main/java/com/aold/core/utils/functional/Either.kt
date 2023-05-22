package com.aold.core.utils.functional

/**
 * @author Kirilin Yury on 22.05.2023.
 */
sealed class Either<out L, out R> {

    data class Left<L>(val data: L) : Either<L, Nothing>()

    data class Right<R>(val data: R) : Either<Nothing, R>()

    val isLeft = this is Left

    val isRight = this is Right
}

typealias DomainResult<L, R> = Either<L, R>

typealias UnitDomainResult<L> = Either<L, Unit>

fun <L, R> Either<L, R>.rightOrElse(elseValue: R): R = when (this) {
    is Either.Left -> elseValue
    is Either.Right -> this.data
}

fun <L, R> Either<L, R>.leftOrElse(elseValue: L): L = when (this) {
    is Either.Left -> this.data
    is Either.Right -> elseValue
}

suspend fun <L, R> Either<L, R>.handle(
    onLeftAction: suspend (L) -> Unit = {},
    onRightAction: suspend (R) -> Unit = {},
) = when (this) {
    is Either.Left -> onLeftAction.invoke(this.data)
    is Either.Right -> onRightAction.invoke(this.data)
}
