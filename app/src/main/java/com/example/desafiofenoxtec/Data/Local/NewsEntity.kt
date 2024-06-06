package com.example.desafiofenoxtec.Data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val titulo:String = "",
    val introducao:String = "",
    val data_publicacao:String = "",
    val image:String = ""

)
