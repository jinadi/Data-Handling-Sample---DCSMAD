package com.example.datahandlingsample.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.datahandlingsample.data.entities.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * From user_table")
    //fun getAllUsers(): List<User>
    fun getAllUsers():Flow<List<User>>
}