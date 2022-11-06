package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import ktor.models.KtorSearchGame
import ktor.models.KtorSearchRequest
import models.Game

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.post("/games/search") {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")
            setBody(KtorSearchRequest(""))
        }.body()
    }

    suspend fun searchGame(query: String): List<KtorSearchGame> {
        val games: List<KtorSearchGame> = httpClient.post("/games/search") {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")
            setBody(KtorSearchRequest(query))
        }.body()
        return games
    }
}