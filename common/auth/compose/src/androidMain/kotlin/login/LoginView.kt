package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Now", color = Theme.colors.thirdTextColor,
            fontSize = 24.sp, fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welocome back to playzone ENter your email",
            fontSize = 14.sp,
            color = Theme.colors.hintTextColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

        TextField(value = state.email, onValueChange = {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }, enabled = !state.isSending,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xff1f2430),
                textColor = Theme.colors.hintTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Theme.colors.highlightTextColor
            ), shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            placeholder = {
                Text("Your login", color = Theme.colors.hintTextColor,
                    fontSize = 14.sp)
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(value = state.password, onValueChange = {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }, enabled = !state.isSending, colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xff1f2430),
            textColor = Theme.colors.hintTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Theme.colors.highlightTextColor
        ), shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            placeholder = {
                Text("Your password", color = Theme.colors.hintTextColor,
                    fontSize = 14.sp)
            },
            visualTransformation = if (state.passwordHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        eventHandler.invoke(LoginEvent.PasswordShowClick)
                    },
                    imageVector = if(state.passwordHidden) {
                        Icons.Outlined.Lock
                    } else {
                        Icons.Outlined.Clear
                    }, contentDescription = "Password hidden", tint = Theme.colors.hintTextColor)
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text("Forgot Password",
                modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.ForgotClick) },
                color = Theme.colors.primaryAction,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isSending,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                eventHandler.invoke(LoginEvent.LoginClick)
            }) {
            Text("Login Now",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}