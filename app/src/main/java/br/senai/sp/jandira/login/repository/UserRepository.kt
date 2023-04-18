package br.senai.sp.jandira.login.repository

import android.content.Context
import br.senai.sp.jandira.login.dao.TripDb
import br.senai.sp.jandira.login.model.User

class UserRepository(context: Context) {
    // Variável que representa nosso banco de dados
    private val db = TripDb.getDataBase(context)
    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    // Responsavel por encontrar um usuário por e-mail
    fun findUserByEmail(email: String): User {
        return db.userDao().findUserByEmail(email)
    }

    // Responsavel pela autenticação do Úsuario
    fun authenticate(email: String, password: String): User {
        return db.userDao().authenticate(email, password)
    }

}