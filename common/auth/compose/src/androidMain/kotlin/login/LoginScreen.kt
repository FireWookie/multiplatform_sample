import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.LoginView
import login.LoginViewModel
import login.models.LoginAction
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag


@Preview
@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        LoginView(state.value) {
            viewModel.obtainEvent(it)
        }

        when(action.value) {
            is LoginAction.OpenMainFlow -> {
                rootController.findRootController().present(NavigationTree.Main.Dashboard.name, launchFlag = LaunchFlag.SingleNewTask)
            }
            LoginAction.OpenForgotPassword -> rootController.push(NavigationTree.Auth.Register.name)
            LoginAction.OpenRegistration -> rootController.push(NavigationTree.Auth.Register.name)
            null -> {}
        }
    }
}