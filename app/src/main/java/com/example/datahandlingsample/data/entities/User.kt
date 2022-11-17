package com.example.datahandlingsample.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
  //  @ColumnInfo(name = "first_name")
    val firstName:String?,
    val lastName:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
