package ru.eetk.network.utils

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [Failure] class.
 */
sealed class Failure(override val message: String) : Throwable() {
    class Http(val code: Int, override val message: String) : Failure(message)
    class Message(message: String) : Failure(message)
    class UseCase(val e: Exception) : Failure(e.message.orEmpty())
    object InternetConnection : Failure("Нет подключения к интернету")
    object NotFound : Failure("")
    object Unknown : Failure("Попробуйте позже")
    object AuthTokenFailure : Failure("")
    object StatusChange : Failure("")
    object Status : Failure("")
    object ProfileNotFound : Failure("ProfileNotFound")
    object ImageFailure : Failure("ImageFailure")
    object NotAuth : Failure("Вы не авторизованы")
    class ErrorPassword(val type: String, override val message: String) :
        Failure("Неправильный пароль")

    class Login2FA(val uniqueRequestId: String, override val message: String) : Failure(message)
    class SmsLimit(override val message: String, val type: String, val ttl: Int) :
        Failure(message)
}