package ktor

@kotlinx.serialization.Serializable
data class KtorLoginRequest(
    val login: String,
    val password: String
)
