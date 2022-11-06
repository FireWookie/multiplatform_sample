package search

import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.mp.KoinPlatformTools
import search.models.SearchAction
import search.models.SearchEvent
import search.models.SearchViewState

class SearchViewModel: BaseSharedViewModel<SearchViewState, SearchAction, SearchEvent>(
    initialState = SearchViewState()
) {

    private val gamesRepository: GamesRepository = KoinPlatformTools.defaultContext().get().get()
    private var searchJob: Job? = null

    override fun obtainEvent(viewEvent: SearchEvent) {
        when(viewEvent) {
            SearchEvent.GameClicked -> showDetailGame()
            is SearchEvent.QueryChanged -> searchGame(query = viewEvent.query)
        }
    }

    private fun showDetailGame() {
        viewAction = SearchAction.ShowGameDetail
    }

    private fun searchGame(query: String) {
        searchJob = viewModelScope.launch {
            viewState = viewState.copy(query = query)
            searchJob?.cancel()
            delay(500)
            viewState = try {
                val gamesResponse = gamesRepository.searchGame(query)
                viewState.copy(game = gamesResponse)
            } catch (e: Exception) {
                viewState.copy()
            }
        }
    }
}