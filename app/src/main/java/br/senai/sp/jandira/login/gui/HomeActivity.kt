package br.senai.sp.jandira.login.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.R
import br.senai.sp.jandira.login.model.Category
import br.senai.sp.jandira.login.model.Trip
import br.senai.sp.jandira.login.repository.CategoryRepository
import br.senai.sp.jandira.login.repository.TripRepository
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras
        Log.i(
            "ds2m",
            "id"
        )

        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    HomeScreen(CategoryRepository.getCategories(),
                    TripRepository.getTrips()
                        )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    categories: List<Category>,
    trip:List<Trip>
    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RectangleShape

        ) {
            Image(
                painter = painterResource(id = br.senai.sp.jandira.login.R.drawable.paris),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = stringResource(id = br.senai.sp.jandira.login.R.string.categories),
            color = Color(56, 54, 54),
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)

        )
        var cidades = listOf(1, 2, 3, 4, 5, 6, 7)
        LazyRow(modifier = Modifier.padding(start = 16.dp, top = 1.dp)) {
            items(categories) {
                Card(
                    modifier = Modifier
                        .size(width = 109.dp, height = 80.dp)
                        .padding(vertical = 8.dp, horizontal = 2.5.dp,),
                    backgroundColor = Color.Magenta
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = it.categoryIcon,
                            contentDescription = it.categoryName
                        )
                        Text(
                            text = it.categoryName,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }

            }


        }
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.search))
            },
            colors = TextFieldDefaults
                .outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Magenta

                ),
            trailingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )

            Text(
                text = stringResource(id = R.string.text_cards),
                color = Color(56, 54, 54),
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(start = 19.dp, top = 5.dp)
            )


        Spacer(modifier = Modifier.fillMaxWidth())

        LazyColumn(){
            items(trip){
                Card(modifier = Modifier.fillMaxWidth().padding(15.dp), backgroundColor =  Color.Green) {
                    Column() {
                        Image(painter = painterResource(id = R.drawable.baseline_no_photography_24), contentDescription = "")
                        Text(text = "${it.location}, ${it.startDate.year}")
                        Text(text = "${it.description}")
                        Text(
                            text = "${it.startDate}, ${it.endDate}",
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                            )

                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LoginTheme {
      HomeScreen(
          CategoryRepository.getCategories(),
          TripRepository.getTrips()
      )
    }
}