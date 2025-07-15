package com.example.courses.ui.feature.presintashion.register.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.ui.feature.presintashion.entrance.ui.EmailVisualTransformation
import com.example.courses.ui.feature.presintashion.entrance.ui.Services
import com.example.courses.ui.feature.presintashion.entrance.ui.isValidEmailInput
import com.example.courses.ui.feature.shared.button.CButton
import com.example.courses.ui.feature.shared.text.textfield.CoursesTextField
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors

@Composable
fun RegistrationScreen(
    openEntranceScreen: () -> Unit,
    openHomeScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.dark)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        RegistrationContent(
            openHomeScreen = openHomeScreen,
            openEntranceScreen = openEntranceScreen
        )
    }
}

@Composable
fun RegistrationContent(
    openHomeScreen: () -> Unit,
    openEntranceScreen: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }

    LaunchedEffect(email, password) {
        isValid = email.isNotBlank()
                && password.length >= 8
                && password == repeatPassword
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.small_registration),
            color = MaterialTheme.colors.white,
            style = CoursesTypography.titleMedium,
        )
        Spacer(modifier = Modifier.height(28.dp))
        Content(
            email = email,
            password = password,
            onEmailChange = {email = it},
            onPasswordChange = {password = it},
            openHomeScreen = openHomeScreen,
            enable = isValid,
            openEntranceScreen = openEntranceScreen,
            repeatPassword = repeatPassword,
            onRepeatPasswordChange = { repeatPassword = it }
        )
    }
}

@Composable
private fun Content(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    openHomeScreen: () -> Unit,
    enable: Boolean,
    repeatPassword: String,
    onRepeatPasswordChange: (String) -> Unit,
    openEntranceScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldEmailAndPassword(
            email = email,
            password = password,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            repeatPassword = repeatPassword,
            onRepeatPasswordChange = onRepeatPasswordChange
        )
        Spacer(modifier = Modifier.height(24.dp))
        CButton(
            enable = enable,
            onClick = openHomeScreen,
            text = stringResource(R.string.small_registration),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = stringResource(R.string.do_you_already_have_an_account),
                color = MaterialTheme.colors.white,
                style = CoursesTypography.labelMedium
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = stringResource(R.string.entrance),
                color = MaterialTheme.colors.green,
                style = CoursesTypography.labelMedium,
                modifier = Modifier.clickable(onClick = openEntranceScreen)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.stroke)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Services()
    }
}

@Composable
private fun TextFieldEmailAndPassword(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    repeatPassword: String,
    onRepeatPasswordChange: (String) -> Unit
) {
    val visualTransformation = remember { EmailVisualTransformation() }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CoursesTextField(
            label = stringResource(R.string.email),
            value = email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            visualTransformation = visualTransformation,
            onValueChange = {
                if (it.isValidEmailInput()) {
                    onEmailChange(it)
                }
            },
            placeholder = stringResource(R.string.enter_email),
        )
        Spacer(modifier = Modifier.height(16.dp))
        CoursesTextField(
            label = stringResource(R.string.password),
            value = password,
            onValueChange = onPasswordChange,
            placeholder = stringResource(R.string.enter_password),
        )
        Spacer(modifier = Modifier.height(16.dp))
        CoursesTextField(
            label = stringResource(R.string.repeat_password),
            value = repeatPassword,
            onValueChange = onRepeatPasswordChange,
            placeholder = stringResource(R.string.repeat_password_again),
        )
    }
}