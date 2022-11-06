package login

import com.adeo.kviewmodel.BaseSharedViewModel
import org.koin.core.component.KoinComponent

abstract class AbstractVM<State: Any, Action, Event>(
    private val initialState: State
): BaseSharedViewModel<State, Action, Event>(initialState = initialState), KoinComponent