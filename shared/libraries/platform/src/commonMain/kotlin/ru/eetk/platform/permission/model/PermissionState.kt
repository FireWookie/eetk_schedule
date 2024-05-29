package ru.eetk.platform.permission.model


/**
 * Represents the state of a permission
 */
enum class PermissionState {
    /**
     * Indicates that the permission has not been requested yet
     */
    NOT_DETERMINED,

    /**
     * Indicates that the permission has been requested and accepted.
     */
    GRANTED,

    /**
     * Indicates that the permission has been requested but the user denied the permission
     */
    DENIED;

    /**
     * Extension function to check if the permission is not granted
     */
    fun notGranted(): Boolean {
        return this != GRANTED
    }

    fun denied(): Boolean {
        return this == DENIED
    }

    fun granted() : Boolean {
         return this == GRANTED
    }
}

