package models

import kotlinx.serialization.Serializable


@Serializable
enum class BranchUI(val college: Int) {
    MTO(1),
    ETO(2)
}