package models

import kotlinx.serialization.Serializable


@Serializable
enum class BranchUI(val collage: Int) {
    MTO(1),
    ETO(2)
}