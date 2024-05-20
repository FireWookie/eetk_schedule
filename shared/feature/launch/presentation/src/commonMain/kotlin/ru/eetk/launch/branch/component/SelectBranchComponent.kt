package ru.eetk.launch.branch.component

import models.BranchUI

interface SelectBranchComponent {
    fun onSelectBranch(branch: BranchUI)
}