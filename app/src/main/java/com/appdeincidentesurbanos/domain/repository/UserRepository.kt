package com.appdeincidentesurbanos.domain.repository

import android.content.Context
import com.appdeincidentesurbanos.data.local.AppDatabase
import com.appdeincidentesurbanos.data.local.UserEntity

class UserRepository(context: Context) {
    private val userDao = AppDatabase.getDatabase(context).userDao()

    suspend fun registerUser(user: UserEntity) {
        userDao.insert(user)
    }

    suspend fun loginUser(email: String, password: String): UserEntity? {
        return userDao.login(email, password)
    }

    suspend fun isEmailRegistered(email: String): Boolean {
        return userDao.getUserByEmail(email) != null
    }
}
