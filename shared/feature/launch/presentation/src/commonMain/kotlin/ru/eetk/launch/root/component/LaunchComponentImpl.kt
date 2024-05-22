package ru.eetk.launch.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import kotlinx.serialization.Serializable
import models.BranchUI
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import ru.eetk.launch.branch.component.buildSelectBranchComponent
import ru.eetk.launch.course.component.buildSelectCourseComponent

fun buildLaunchComponent(
    componentContext: ComponentContext,
    onOpenMainFlow: () -> Unit,
): LaunchComponent = LaunchComponentImpl(
    componentContext = componentContext,
    onOpenMainFlow = onOpenMainFlow
)

internal class LaunchComponentImpl(
    componentContext: ComponentContext,
    private val onOpenMainFlow: () -> Unit
) : LaunchComponent, ComponentContext by componentContext, KoinComponent, BackHandlerOwner {

    private val navigation = StackNavigation<Config>()

    override fun openMainFlow() = onOpenMainFlow()

    override val childStack: Value<ChildStack<*, LaunchComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.SelectBranch,
            handleBackButton = true,
            childFactory = ::processChild,
            serializer = Config.serializer()
        )

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ) = when (config) {
        Config.SelectBranch -> LaunchComponent.Child.Branch(
            buildSelectBranchComponent(
                componentContext = componentContext,
                onSelectBranch = {
                    navigation.push(Config.SelectCourse(it))
                }
            )
        )
        is Config.SelectCourse -> LaunchComponent.Child.Course(
            buildSelectCourseComponent(
                componentContext = componentContext,
                branchUI = config.branch,
                onOpenMainFlow = onOpenMainFlow,
            )
        )
    }

    override fun onBackClicked() {
        navigation.pop()
    }


    @Serializable
    sealed interface Config {
        @Serializable
        data object SelectBranch: Config

        @Serializable
        data class SelectCourse(val branch: BranchUI): Config
    }
}