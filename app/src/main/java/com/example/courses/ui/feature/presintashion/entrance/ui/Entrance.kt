package com.example.courses.ui.feature.presintashion.entrance.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.ui.feature.shared.button.CButton
import com.example.courses.ui.feature.shared.text.textfield.CoursesTextField
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors
import kotlin.String
import androidx.core.net.toUri

@Preview
@Composable
private fun EntranceScreenPreview() {
    EntranceScreen {  }
}


@Composable
fun EntranceScreen(
    openHomeScreen: () -> Unit
) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colors.dark)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            EntranceContent(
                openHomeScreen = openHomeScreen
            )
        }
}

@Composable
fun EntranceContent(
    openHomeScreen: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }

    LaunchedEffect(email, password) {
        isValid = email.isNotBlank() && password.length >= 8
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.heading_entrance),
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
            enable = isValid
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
    enable: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextFieldEmailAndPassword(
            email = email,
            password = password,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        CButton(
            enable = enable,
            onClick = openHomeScreen,
            text = stringResource(R.string.heading_entrance),
            color = MaterialTheme.colors.green,
        )
        Spacer(modifier = Modifier.height(16.dp))
        NotAccountAndForgotYourPassword(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
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
    onPasswordChange: (String) -> Unit
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
    }
}

@Composable
fun NotAccountAndForgotYourPassword(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
           Text(
               text = stringResource(R.string.not_account),
               color = MaterialTheme.colors.white,
               style = CoursesTypography.labelMedium
           )
            Spacer(modifier = Modifier.width(3.dp))
           Text(
               text = stringResource(R.string.small_registration),
               color = MaterialTheme.colors.green,
               style = CoursesTypography.labelMedium,
               modifier = Modifier.clickable(onClick = {})
           )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.forgot_your_password),
            color = MaterialTheme.colors.green,
            style = CoursesTypography.labelMedium,
            modifier = Modifier.clickable(onClick = {})
        )
    }
}

@Composable
private fun Services(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Service(
            modifier = Modifier
                .weight(0.5f)
                .background(color = Color(0xFF2683ED), shape = RoundedCornerShape(30.dp)),
            icon = R.drawable.ic_wk,
            onClick = { openWebSite(context, "https://vk.com/") }
        )
        Service(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFF98509),
                            Color(0xFFF95D00)
                        )
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
                .weight(0.5f),
            icon = R.drawable.ic_o,
            onClick = { openWebSite(context, "https://ok.ru/") },
        )
    }
}

@Composable
fun Service(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

fun String.isValidEmailInput(): Boolean {
    val allowedChars = """[a-zA-Z0-9@._-]""".toRegex()
    return this.all { char ->
        allowedChars.matches(char.toString())
    }
}

fun openWebSite(context: Context, url: String){
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    context.startActivity(intent)
}

class EmailVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(text, OffsetMapping.Identity)
    }
}