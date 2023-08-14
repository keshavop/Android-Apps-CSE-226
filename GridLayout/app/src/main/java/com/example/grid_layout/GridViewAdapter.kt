package com.example.grid_layout

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GridViewAdapter(var c:Context, var list:ArrayList<GridModel>) : RecyclerView.Adapter<GridViewAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var name:TextView
        var image: ImageView
        init {
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view:View = LayoutInflater.from(c).inflate(R.layout.custom_grid_view,parent,false);
        return MyHolder(view);
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text = list[position].name
        holder.image.setImageResource(list[position].image)

        holder.itemView.setOnClickListener{
            holder.itemView.setBackgroundColor(Color.RED)
//            Toast.makeText(this, list[position].name + "is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}