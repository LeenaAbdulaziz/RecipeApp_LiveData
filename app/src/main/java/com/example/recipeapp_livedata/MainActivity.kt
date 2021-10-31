package com.example.recipeapp_livedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp_room.data.Recipe
import com.example.recipeapp_room.data.RecipeDatabase

class MainActivity : AppCompatActivity() {

    lateinit var title: EditText
    lateinit var name: EditText
    lateinit var ingre: EditText
    lateinit var instr: EditText
    lateinit var save : Button

    lateinit var myViewModel :MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title=findViewById(R.id.edtitle)
        name=findViewById(R.id.edname)
        ingre=findViewById(R.id.edinge)
        instr=findViewById(R.id.edins)
        save=findViewById(R.id.btnsave)
        myViewModel= ViewModelProvider(this).get(MyViewModel::class.java)

        save.setOnClickListener {
            var s1=title.text.toString()
            var s2=name.text.toString()
            var s3=ingre.text.toString()
            var s4=instr.text.toString()
            if(s1.isNotEmpty()&&s2.isNotEmpty()&&s3.isNotEmpty()&&s4.isNotEmpty())
            {
                myViewModel.addNotes(0,s1,s2,s3,s4)
                title.text.clear()
                name.text.clear()
                ingre.text.clear()
                instr.text.clear()
                Toast.makeText(applicationContext, "data successfully added", Toast.LENGTH_SHORT)
                    .show()
            }
            else{
                Toast.makeText(applicationContext,"one or more field empty", Toast.LENGTH_SHORT).show()
            }


        }

    }

    fun viewreceipe(view: View) {
        startActivity(Intent(this,Mainpage::class.java))
    }
}