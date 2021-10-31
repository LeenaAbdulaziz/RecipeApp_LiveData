package com.example.recipeapp_room.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecepeDao {
    @Query("SELECT * FROM Recipe ORDER BY title DESC")
    fun getAllUserInfo(): LiveData<List<Recipe>>

    @Insert
    fun insertrecipe(n: Recipe)
    @Update
    fun updaterecipe(recipe: Recipe)
    @Delete
    fun deleterecipe(recipe: Recipe)

}