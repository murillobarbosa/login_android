package br.senai.sp.jandira.login.repository

import br.senai.sp.jandira.login.model.Trip
import java.time.LocalDate

class TripRepository {
    companion object{
        fun getTrips(): List<Trip>{
            return  listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Cidade muito bonita, com muitas opções de passeio",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,21),
                ),
                Trip(
                    id = 2,
                    location = "Cotia",
                    description = "Cidade muito bonita, para fazer o que você deseja",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,21),
                ),
                Trip(
                    id = 3,
                    location = "São Paulo",
                    description = "Cidade muito bonita, com muitas opções de passeio",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,21),
                )
            )
        }
    }
}