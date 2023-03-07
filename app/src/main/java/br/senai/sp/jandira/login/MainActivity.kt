package br.senai.sp.jandira.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
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
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp)
                                    .background(
                                        color = Color(207, 6, 240),
                                        shape = RoundedCornerShape(bottomStart = 20.dp)
                                    )
                            ) {
                                {}
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(130.dp))
                        
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = stringResource(id = R.string.title_login), Modifier.padding(start = 20.dp),
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(207, 6, 240),


                                )
                            Text(text = stringResource(id = R.string.description_title_login), Modifier.padding(start = 20.dp),
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(160, 156, 156, )
                            )

                        }
                        Column(modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start) {

                            OutlinedTextField(
                                value = "",
                                onValueChange = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 24.dp, end = 20.dp, top = 70.dp),
                                shape = RoundedCornerShape(16.dp),
                                leadingIcon = {
                                    Image(painter = painterResource(id = R.drawable.email), contentDescription = "",
                                        modifier = Modifier
                                            .size(31.dp)
                                            .padding(start = 5.dp)
                                        )
                                }



                            )

                            OutlinedTextField(
                                value = "",
                                onValueChange = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 24.dp, end = 20.dp, top = 31.dp),
                                shape = RoundedCornerShape(16.dp),
                                leadingIcon = {
                                    Image(painter = painterResource(id = R.drawable.password), contentDescription = "",
                                        modifier = Modifier
                                            .size(31.dp)
                                            .padding(start = 5.dp)
                                    )
                                }


                                )
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Column(modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
                            horizontalAlignment = Alignment.End,

                            ) {
                            Button(onClick = {},
                                shape = RoundedCornerShape(16.dp), modifier = Modifier.width(134.dp).height(48.dp).background(color = (Color(207, 6, 240))),
                            ) {
                                Text(text = stringResource(id = R.string.button_login),
                                color = Color.White)
                            }
                        }


                    }

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginTheme {
        Greeting("Android")
    }
}