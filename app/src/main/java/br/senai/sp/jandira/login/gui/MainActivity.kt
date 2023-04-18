package br.senai.sp.jandira.login.gui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.R
import br.senai.sp.jandira.login.components.BottomShape
import br.senai.sp.jandira.login.components.TopShape
import br.senai.sp.jandira.login.repository.UserRepository
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                val context = LocalContext.current

                var emailState by remember {
                    mutableStateOf("")
                }

                var passwordState by remember {
                    mutableStateOf("")
                }

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            TopShape()
                        }
                        Spacer(modifier = Modifier.height(130.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(
                                text = stringResource(id = R.string.title_login),
                                Modifier.padding(start = 20.dp),
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(207, 6, 240)
                            )

                            Text(
                                text = stringResource(id = R.string.description_title_login),
                                Modifier.padding(start = 20.dp),
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(160, 156, 156)
                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {

                            OutlinedTextField(
                                value = emailState,
                                onValueChange = {
                                    emailState = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 80.dp, start = 24.dp, end = 20.dp),
                                shape = RoundedCornerShape(16.dp),
                                label =
                                {
                                    Text(text = stringResource(id = R.string.name_email))
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource
                                            (id = R.drawable.email),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 5.dp)
                                    )
                                },
                                colors = TextFieldDefaults
                                    .outlinedTextFieldColors(
                                        focusedBorderColor = Color(207, 6, 240),
                                        unfocusedBorderColor = Color(207, 6, 240)

                                    )
                            )

                            OutlinedTextField(
                                value = passwordState,
                                onValueChange = {
                                    passwordState = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 31.dp, start = 24.dp, end = 20.dp),
                                shape = RoundedCornerShape(16.dp),
                                label =
                                {
                                    Text(text = stringResource(id = R.string.name_password))
                                },
                                visualTransformation = PasswordVisualTransformation(),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource
                                            (id = R.drawable.password),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 5.dp)
                                    )
                                },
                                colors = TextFieldDefaults
                                    .outlinedTextFieldColors(
                                        focusedBorderColor = Color(207, 6, 240),
                                        unfocusedBorderColor = Color(207, 6, 240)

                                    )

                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Button(
                                onClick = {
                                    authenticate(emailState, passwordState, context)
                                },
                                modifier = Modifier
                                    .width(134.dp)
                                    .height(48.dp),
                                colors = ButtonDefaults.buttonColors(Color(207, 6, 244)),
                                shape = RoundedCornerShape(16.dp),

                                ) {
                                Text(
                                    text = stringResource(id = R.string.button_login),
                                    color = Color.White
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        )
                        {
                            Text(
                                text = stringResource(id = R.string.new_account),
                                Modifier.padding(top = 15.dp),
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(160, 156, 156)
                            )
                            Text(
                                text = stringResource(id = R.string.title_sing_up),
                                Modifier
                                    .padding(end = 20.dp, start = 10.dp, top = 15.dp)
                                    .clickable {
                                        val intent = Intent(context, SignUpActivity2::class.java)
                                        context.startActivity(intent)
                                    },
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(207, 6, 240)


                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Bottom

                        ) {
                            BottomShape()
                        }
                    }
                }
            }
        }
    }

    private fun authenticate(email: String, password: String, context: Context) {
        val userRepository = UserRepository(context)

        val user = userRepository.authenticate(email, password)

        if (user == null) {
            Toast.makeText(
                context, "User or password incorrect!",
                Toast.LENGTH_SHORT
            )
                .show()
        } else {
            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra("id", user.id)
            intent.putExtra("name", user.userName)
            context.startActivity(intent)
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")


}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    LoginTheme {
        Greeting("Android")
    }
}
