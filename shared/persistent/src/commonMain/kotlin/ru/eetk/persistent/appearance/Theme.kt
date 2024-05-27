package ru.eetk.persistent.appearance

enum class Theme(val theme: Int) {
    System(0),
    Dark(1),
    Light(2);

    companion object {
        fun fromOrdinal(ordinal: Int) = entries[ordinal]
    }
}