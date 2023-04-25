package br.senai.sp.jandira.login.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.login.R
import br.senai.sp.jandira.login.model.Category

class CategoryRepository {
    companion object{
        @Composable
        fun getCategories(): List<Category>{
            return listOf(
                Category(id = 1,
                    categoryName = "Montain",
                    categoryIcon = painterResource(id = R.drawable.montain)
                ),
                Category(id = 1,
                    categoryName = "Snow",
                    categoryIcon = painterResource(id = R.drawable.snowboarder)
                ),
                Category(id = 1,
                    categoryName = "Beach",
                    categoryIcon = painterResource(id = R.drawable.breach)
                ),
                Category(id = 1,
                    categoryName = "Business",
                    categoryIcon = painterResource(id = R.drawable.suitcase)
                )
            )
        }
    }
}