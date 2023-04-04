package br.senai.sp.jandira.login.repository

import android.content.Context
import br.senai.sp.jandira.login.dao.TripDb
import br.senai.sp.jandira.login.model.User

class UserRepository(context: Context) {
    // Variável que representa nosso banco de dados
    private val db = TripDb.getDataBase(context)
    fun save(user: User): Long{
        return db.userDao().save(user)
    }

}