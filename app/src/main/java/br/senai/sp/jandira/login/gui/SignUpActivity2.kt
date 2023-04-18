package br.senai.sp.jandira.login.gui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import br.senai.sp.jandira.login.model.User
import br.senai.sp.jandira.login.repository.UserRepository
import br.senai.sp.jandira.login.ui.theme.LoginTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import java.net.PasswordAuthentication

class SignUpActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {

                var photoUri by remember {
                    mutableStateOf<Uri?>(null)
                }

                var launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.GetContent()
                ) { uri ->
                    photoUri = uri
                }

                var painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(photoUri)
                        .build()
                )
                // A surface container using the 'background' color from the theme
                var scrollState = rememberScrollState()

                var userNameState by rememberSaveable {
                    mutableStateOf("")
                }

                var phoneState by remember {
                    mutableStateOf("")
                }

                var passwordState by remember {
                    mutableStateOf("")
                }

                var emailState by remember {
                    mutableStateOf("")
                }

                var over18State by remember {
                    mutableStateOf(false)
                }

                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                shape = RoundedCornerShape(bottomStart = 28.dp),
                                backgroundColor = Color(207, 6, 240),
                            ) {}
                        }
                        Spacer(modifier = Modifier.height(50.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.title_sing_up),
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(207, 6, 240)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.create_account),
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(160, 156, 156)
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .align(alignment = Alignment.CenterHorizontally)
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(100.dp)
                                    .align(alignment = Alignment.BottomCenter)
                                    .size(50.dp),
                                shape = CircleShape,
                                backgroundColor = Color(232, 232, 232, 255),
                            ) {
                                Image(
                                    painter = if(photoUri == null) painterResource(id = R.drawable.user1) else painter,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                            }
                            Image(painter = painterResource(id = R.drawable.baseline_add_a_photo_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .clickable {
                                        launcher.launch("image/*")
                                        var message = "nada"
                                        Log.i(
                                            "ds2m",
                                            "${photoUri?.path ?: message}"
                                        )
                                    }
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()

                        ) {

                            Column(
                                modifier = Modifier
                                    .height(height = 335.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                //////////////////
                                OutlinedTextField(
                                    value = userNameState, onValueChange = { userNameState = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 24.dp, end = 20.dp),
                                    label =
                                    {
                                        Text(text = stringResource(id = R.string.username))
                                    },
                                    shape = RoundedCornerShape(16.dp),
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.user),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(30.dp)
                                                .padding(start = 5.dp),


                                        )
                                    },
                                    colors = TextFieldDefaults
                                        .outlinedTextFieldColors(
                                            focusedBorderColor = Color(207, 6, 240),
                                            unfocusedBorderColor = Color(207, 6, 240)

                                        )

                                )

                                OutlinedTextField(
                                    value = phoneState, onValueChange = { phoneState = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 15.dp, start = 24.dp, end = 20.dp),
                                    label =
                                    {
                                        Text(text = stringResource(id = R.string.name_phone))
                                    },
                                    shape = RoundedCornerShape(16.dp),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.phone),
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
                                    value = emailState, onValueChange = { emailState = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 15.dp, start = 24.dp, end = 20.dp),
                                    shape = RoundedCornerShape(16.dp),
                                    label =
                                    {
                                        Text(text = stringResource(id = R.string.name_email))
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.email),
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
                                    value = passwordState, onValueChange = { passwordState = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 15.dp, start = 24.dp, end = 20.dp),
                                    shape = RoundedCornerShape(16.dp),
                                    label =
                                    {
                                        Text(text = stringResource(id = R.string.name_password))
                                    },
                                    visualTransformation = PasswordVisualTransformation(),
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.password),
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
                                Spacer(modifier = Modifier.height(21.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically

                                ) {
                                    Checkbox(
                                        checked = over18State, onCheckedChange = { checked ->
                                            over18State = checked
                                        },
                                        modifier = Modifier
                                            .width(27.dp)
                                            .height(27.dp)
                                            .padding(start = 49.dp)

                                    )
                                    Text(
                                        text = stringResource(id = R.string.your_age),
                                        modifier = Modifier.padding(start = 40.dp),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                }

                                Spacer(modifier = Modifier.height(26.dp))

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 0.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            saveUser(
                                                userNameState,
                                                phoneState,
                                                emailState,
                                                passwordState,
                                                over18State,
                                                photoUri?.path ?: "",
                                                context

                                            )
                                        },
                                        modifier = Modifier
                                            .width(327.dp)
                                            .height(48.dp),
                                        colors = ButtonDefaults.buttonColors(Color(207, 6, 244)),

                                        shape = RoundedCornerShape(16.dp),

                                        ) {
                                        Text(
                                            text = stringResource(id = R.string.button_new_account),
                                            color = Color.White
                                        )
                                    }
                                }

                                //////
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                )
                                {
                                    Text(
                                        text = stringResource(id = R.string.new_account),
                                        Modifier.padding(top = 15.dp),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Light,
                                        color = Color(160, 156, 156)
                                    )
                                    Text(
                                        text = stringResource(id = R.string.button_login),
                                        Modifier
                                            .padding(end = 50.dp, start = 10.dp, top = 15.dp)
                                            .clickable {
                                                val intent =
                                                    Intent(context, HomeActivity::class.java)
                                                context.startActivity(intent)
                                            },

                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Light,
                                        color = Color(207, 6, 240)


                                    )
                                }

                            }

                        }



                        Spacer(modifier = Modifier.height(16.dp))



                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Bottom

                        ) {
                            Card(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                shape = RoundedCornerShape(topEnd = 28.dp),
                                backgroundColor = Color(207, 6, 240),
                            ) {

                            }
                        }
                    }

                }
            }
        }
    }

    private fun saveUser(
        userName: String,
        phone: String,
        email: String,
        password: String,
        isOver18: Boolean,
        profilePhotoUri: String,
        context: Context
    ) {

        // Criando um objeto User
        val newUser = User(
            id = 0,
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver18,
            profilePhoto = profilePhotoUri
        )

        // Criando uma instância do repositório
        val userRepository = UserRepository(context)

        // Verificar se o usuário já existe
        val user = userRepository.findUserByEmail(email)
        Log.i("ds3m", "${user.toString()}")


//
        // Salvar o usúario
        if (user == null) {
            val id = userRepository.save(newUser)
            Toast.makeText(context, "Created User #$id", Toast.LENGTH_SHORT).show()
        }


    }
}


@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LoginTheme {
        Greeting2("Android")
    }
}