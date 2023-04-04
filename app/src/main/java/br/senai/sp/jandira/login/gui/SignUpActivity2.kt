package br.senai.sp.jandira.login.gui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.R
import br.senai.sp.jandira.login.model.User
import br.senai.sp.jandira.login.repository.UserRepository
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class SignUpActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = User(
            userName = "Maria da Silva",
            email = "maria@terra.com.br",
            password = "123456",
            phone = "(11)99999-9999",
            isOver18 = true
        )
        val userRep = UserRepository(this)
        val id = userRep.save(user)

        Toast.makeText(this, "$id", Toast.LENGTH_LONG).show()
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                var scrollState = rememberScrollState()

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
                          Card (modifier = Modifier
                              .width(150.dp)
                              .height(50.dp),
                              shape = RoundedCornerShape(bottomStart = 28.dp),
                              backgroundColor = Color(207, 6, 240),) {}
                      }
                      Spacer(modifier = Modifier.height(50.dp))

                      Row(
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.Center
                      ) {
                          Text(text = stringResource(id = R.string.title_sing_up),
                              fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color(207, 6, 240)
                              )
                      }

                      Row(
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.Center
                      ) {
                          Text(text = stringResource(id = R.string.create_account),
                              fontSize = 19.sp, fontWeight = FontWeight.Light, color = Color(160, 156, 156)
                          )
                      }

                      Spacer(modifier = Modifier.height(20.dp))

                      Box(modifier = Modifier.size(100.dp)) {
                          Card(modifier = Modifier
                              .size(100.dp),
                              shape = CircleShape,
                              backgroundColor = Color(232,232,232,255)) {
                              Image(painter = painterResource(id = R.drawable.user1), contentDescription =null
                              )

                          }

                      }

                      Spacer(modifier = Modifier.height(10.dp))

                      Column(
                          modifier = Modifier.fillMaxWidth()

                      ) {

                          Column(modifier = Modifier
                              .height(height = 335.dp)
                              .verticalScroll(rememberScrollState())) {
                              //////////////////
                              OutlinedTextField(value = "", onValueChange ={""},
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .padding(start = 24.dp, end = 20.dp),
                                  shape = RoundedCornerShape(16.dp),
                                  leadingIcon = {
                                      Image(painter = painterResource(id = R.drawable.email), contentDescription = "",
                                          modifier = Modifier
                                              .size(30.dp)
                                              .padding(start = 5.dp)

                                      )
                                  },
                                  colors = TextFieldDefaults
                                      .outlinedTextFieldColors(
                                          focusedBorderColor = Color(207, 6, 240) ,
                                          unfocusedBorderColor = Color(207, 6, 240)

                                      )

                              )

                              OutlinedTextField(value = "", onValueChange ={""},
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .padding(top = 15.dp, start = 24.dp, end = 20.dp),
                                  shape = RoundedCornerShape(16.dp),
                                  leadingIcon = {
                                      Image(painter = painterResource(id = R.drawable.user), contentDescription = "",
                                          modifier = Modifier
                                              .size(30.dp)
                                              .padding(start = 5.dp)

                                      )
                                  },
                                  colors = TextFieldDefaults
                                      .outlinedTextFieldColors(
                                          focusedBorderColor = Color(207, 6, 240) ,
                                          unfocusedBorderColor = Color(207, 6, 240)

                                      )

                              )

                              OutlinedTextField(value = "", onValueChange ={""},
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .padding(top = 15.dp, start = 24.dp, end = 20.dp),
                                  shape = RoundedCornerShape(16.dp),
                                  leadingIcon = {
                                      Image(painter = painterResource(id = R.drawable.phone), contentDescription = "",
                                          modifier = Modifier
                                              .size(30.dp)
                                              .padding(start = 5.dp)

                                      )
                                  },
                                  colors = TextFieldDefaults
                                      .outlinedTextFieldColors(
                                          focusedBorderColor = Color(207, 6, 240) ,
                                          unfocusedBorderColor = Color(207, 6, 240)

                                      )

                              )

                              OutlinedTextField(value = "", onValueChange ={""},
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .padding(top = 15.dp, start = 24.dp, end = 20.dp),
                                  shape = RoundedCornerShape(16.dp),
                                  leadingIcon = {
                                      Image(painter = painterResource(id = R.drawable.password), contentDescription = "",
                                          modifier = Modifier
                                              .size(30.dp)
                                              .padding(start = 5.dp)

                                      )
                                  },
                                  colors = TextFieldDefaults
                                      .outlinedTextFieldColors(
                                          focusedBorderColor = Color(207, 6, 240) ,
                                          unfocusedBorderColor = Color(207, 6, 240)

                                      )

                              )
                              Spacer(modifier = Modifier.height(21.dp))

                              Row(
                                  modifier = Modifier.fillMaxWidth(),
                                  verticalAlignment = Alignment.CenterVertically

                              ) {
                                  Checkbox(checked = false, onCheckedChange = {},
                                      modifier = Modifier
                                          .width(27.dp)
                                          .height(27.dp)
                                          .padding(start = 49.dp)

                                  )
                                  Text(text = stringResource(id = R.string.your_age), modifier = Modifier.padding(start =  40.dp),
                                      fontSize = 20.sp, fontWeight = FontWeight.Light
                                  )
                              }

                              Spacer(modifier = Modifier.height(26.dp))

                              Column(
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .padding(top = 0.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally
                              ) {
                                  Button(onClick = {},
                                      modifier = Modifier
                                          .width(327.dp)
                                          .height(48.dp)
                                      , colors = ButtonDefaults.buttonColors(Color(207, 6, 244)),

                                      shape = RoundedCornerShape(16.dp),

                                      ) {
                                      Text(text = stringResource(id = R.string.button_new_account),
                                          color = Color.White)
                                  }
                              }

                              //////
                              Row( modifier = Modifier.fillMaxWidth(),
                                  horizontalArrangement = Arrangement.End)
                              {
                                  Text(text = stringResource(id = R.string.new_account),Modifier.padding(top = 15.dp),
                                      fontSize = 12.sp, fontWeight = FontWeight.Light, color = Color(160, 156, 156)
                                  )
                                  Text(text = stringResource(id = R.string.button_login),
                                      Modifier
                                          .padding(end = 50.dp, start = 10.dp, top = 15.dp)
                                          .clickable {
                                              val intent = Intent(context, HomeActivity::class.java)
                                              context.startActivity(intent)
                                          },

                                      fontSize = 12.sp, fontWeight = FontWeight.Light, color = Color(207, 6, 240)



                                  )
                              }

                          }

                      }



                      Spacer(modifier = Modifier.height(16.dp))



                      Column (
                          modifier = Modifier.fillMaxHeight(),
                          verticalArrangement = Arrangement.Bottom

                      ) {
                          Card (modifier = Modifier
                              .width(150.dp)
                              .height(50.dp),
                              shape = RoundedCornerShape(topEnd = 28.dp),
                              backgroundColor = Color(207, 6, 240),){

                          }
                      }
                  }

                }
            }
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