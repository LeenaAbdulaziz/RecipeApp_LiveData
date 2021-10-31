package com.example.recipeapp_livedata

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp_room.data.Recipe
import com.example.recipeapp_room.data.RecipeDatabase

class Mainpage : AppCompatActivity() {

    lateinit var recycle: RecyclerView
    lateinit var list:List<Recipe>
    lateinit var myViewModel :MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)
        recycle=findViewById(R.id.rv)
        list= listOf()
        myViewModel= ViewModelProvider(this).get(MyViewModel::class.java)

        updatedrecycle()
    }

    fun addrecipe(view: View) {
       startActivity( Intent(this,MainActivity::class.java))

    }


    fun updatedrecycle(){
        myViewModel.getnotes().observe(this,{
                notes1->
                recycle.adapter = RVAdapter (this, notes1)
                recycle.layoutManager = LinearLayoutManager(this)
            })

        }



    fun deleteitem(id:Int) {
        val ob= RecipeDatabase.getinstant(applicationContext)
        myViewModel.deleteNotes(id)

        Toast.makeText(applicationContext,"Successfully deleted", Toast.LENGTH_SHORT).show()

    }

    fun UpdateRec(recipe:Recipe) {
        val ob= RecipeDatabase.getinstant(applicationContext)
        var c=recipe
        val d = AlertDialog.Builder(this)
        lateinit var input: EditText
        lateinit var tb1: EditText
        lateinit var tb2: EditText
        lateinit var tb3: EditText
        lateinit var vv: View

        d.setCancelable(false)
        d.setPositiveButton("update") { _, _ ->
            c.title = input.text.toString()
            c.author = tb1.text.toString()
            c.ingredents = tb2.text.toString()
            c.instruction = tb3.text.toString()
           myViewModel.updatesNotes(c.id,c.title,c.author,c.ingredents,c.instruction)
        }
            .setNegativeButton("Cancel") { d, _ -> d.cancel() }


        val alert = d.create()
        alert.setTitle("Edit celebrity")
        vv=layoutInflater.inflate(R.layout.alert,null)
        alert.setView(vv)
        input= vv.findViewById(R.id.edn)
        tb1=vv.findViewById(R.id.edatb1)
        tb2=vv.findViewById(R.id.edatb2)
        tb3=vv.findViewById(R.id.edatb3)
        input.setText(c.title)
        tb1.setText(c.author)
        tb2.setText(c.ingredents)
        tb3.setText(c.instruction)

        alert.show()

    }


    fun confirm(id:Int ){
        var at= AlertDialog.Builder(this)
        at.setTitle("delete Celebrity")
        at.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
            deleteitem(id)
        })
        at.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        at.show()
    }

}