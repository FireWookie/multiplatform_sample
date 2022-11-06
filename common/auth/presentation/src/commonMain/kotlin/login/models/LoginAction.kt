package login.models

sealed class LoginAction {
    object OpenRegistration: LoginAction()
    object OpenForgotPassword: LoginAction()
    object OpenMainFlow: LoginAction()
}