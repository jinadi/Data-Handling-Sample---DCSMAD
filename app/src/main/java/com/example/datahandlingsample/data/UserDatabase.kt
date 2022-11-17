package com.example.datahandlingsample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.datahandlingsample.data.daos.UserDao
import com.example.datahandlingsample.data.entities.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase:RoomDatabase() {

    abstract fun getUserDaos():UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}