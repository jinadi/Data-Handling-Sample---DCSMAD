package com.example.datahandlingsample.data.repositories

import com.example.datahandlingsample.data.UserDatabase
import com.example.datahandlingsample.data.entities.User

class UserRepository(
    private val db:UserDatabase
) {
    suspend fun insert(user:User) = db.getUserDaos().insertAll(user)
    suspend fun delete(user:User) = db.getUserDaos().delete(user)
    fun getAllUsers() = db.getUserDaos().getAllUsers()
}