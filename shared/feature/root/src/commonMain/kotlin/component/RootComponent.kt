package component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.eetk.launch.root.component.LaunchComponent
import ru.eetk.mainflow.component.MainFlowComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class Launch(val component: LaunchComponent): Child()
        class MainFlow(val component: MainFlowComponent): Child()
    }
}