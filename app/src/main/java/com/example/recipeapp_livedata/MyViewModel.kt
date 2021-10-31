package com.example.recipeapp_livedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipeapp_room.data.Recipe
import com.example.recipeapp_room.data.RecipeDatabase
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyViewModel (activity: Application): AndroidViewModel(activity){
    private val notes:LiveData<List<Recipe>>
   // private val repository:Repository
    val ob= RecipeDatabase.getinstant(activity)

    init {

        notes=ob.RecipeDao().getAllUserInfo()





    }

    fun getnotes(): LiveData<List<Recipe>>{
        return notes
    }

    fun addNotes(id:Int,n1: String,n2: String,n3: String,n4: String) {

        GlobalScope.launch(Main)
        {
  ob.RecipeDao().insertrecipe(Recipe(id, n1,n2,n3,n4))

            }
        }
    fun updatesNotes(id:Int,n1: String,n2: String,n3: String,n4: String) {
        GlobalScope.launch(Main)
        {
            ob.RecipeDao().updaterecipe(Recipe(id, n1,n2,n3,n4))

        }
    }

    fun deleteNotes(id:Int) {
        GlobalScope.launch(Main)
        {
            ob.RecipeDao().deleterecipe(Recipe(id))

        }
    }
    }

