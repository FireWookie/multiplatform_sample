package search.models

import models.Game

data class SearchViewState(
    val query: String = "",
    val game: List<Game> = emptyList()
)