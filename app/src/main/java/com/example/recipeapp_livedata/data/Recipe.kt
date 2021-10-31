package com.example.recipeapp_room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Recipe")
data class Recipe (
        @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id:Int = 0,
        @ColumnInfo(name = "title") var title:String="",
        @ColumnInfo(name = "author") var author:String="",
        @ColumnInfo(name = "Ingredents") var ingredents:String="",
        @ColumnInfo(name = "Instruction") var instruction:String=""
        )
