package com.example.recipeapp_livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp_room.data.Recipe
import kotlinx.android.synthetic.main.item.view.*


//import kotlinx.android.synthetic.main.single_item.view.*

class RVAdapter(val activity: Mainpage, val recipes: List<Recipe>) : RecyclerView.Adapter<RVAdapter.recyclerViewHolder>() {
    class recyclerViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyclerViewHolder {
        return recyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: recyclerViewHolder, position: Int) {
        val recipe = recipes[position]

        holder.itemView.apply {

            textview2.text = "${recipe.title}\n${recipe.author}\n${recipe.ingredents}\n${recipe.instruction}\n"

           imageView.setOnClickListener {
               activity.UpdateRec(recipe)
           }
            imageView2.setOnClickListener {
                activity.confirm(recipe.id)
            }
        }}


    override fun getItemCount()=recipes.size
}