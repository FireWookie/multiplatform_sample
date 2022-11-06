package settings

import com.russhwolf.settings.Settings

class SettingsAuthDataSource(
    private val settings: Settings
) {

    fun saveToken(token: String) {
        settings.putString(tokenKey, token)
    }

    fun fetchToken(): String {
        return settings.getString(tokenKey, "")
    }

    companion object {
        private val tokenKey = "token"
    }
}