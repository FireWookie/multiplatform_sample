package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.mp.KoinPlatformTools


open class LoginViewModel:
    BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>
        (initialState = LoginViewState("", "")
    ) {

    private val authRepository by lazy { KoinPlatformTools.defaultContext().get().get<AuthRepository>() }
    init {
        checkUserLoggedIn()
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.RegistrationClick -> openRegistration()
            is LoginEvent.PasswordShowClick -> changePasswordVisibility()
        }
    }

    private fun checkUserLoggedIn() {
        if (authRepository.isUserLoggedIn()) {
            viewAction = LoginAction.OpenMainFlow
        }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
             try {
                 val response = authRepository.login(viewState.email, viewState.password)
                 if (response.token.isNotBlank()) {
                     println("Install data success")
                     viewState = viewState.copy(email = "", password = "", isSending = false)
                     viewAction = LoginAction.OpenMainFlow
                 } else {
                     println("Install state success")
                     viewState = viewState.copy(isSending = false)
                 }
            } catch (_: Exception) {
                 println("Install state error success")
                viewState = viewState.copy(isSending = false)
            }
        }
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPassword
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistration
    }

    private fun obtainEmailChanged(value: String) {
        println("email changed")
        viewState = viewState.copy(
            email = value
        )
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }
}