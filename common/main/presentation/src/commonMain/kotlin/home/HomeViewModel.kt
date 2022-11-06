package home

import com.adeo.kviewmodel.BaseSharedViewModel
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState

class HomeViewModel: BaseSharedViewModel<HomeViewState, HomeAction, HomeEvent>(
    initialState = HomeViewState(
        username = "Erlink",
        avatarUrl = "https://i.pinimg.com/originals/2e/cb/f3/2ecbf36c37c969fdfe1c2afd0cb52c25.png"
    )
) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when(viewEvent){
            HomeEvent.UserProfileClicked -> TODO()
        }
    }
}