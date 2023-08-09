package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterDemo(var list:MutableList<MyDataModel1>): RecyclerView.Adapter<RecyclerAdapterDemo.MyDemoHolder>()
{
    class MyDemoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title:TextView=itemView.findViewById(R.id.title)
        var general:TextView=itemView.findViewById(R.id.genre)
        var year:TextView=itemView.findViewById(R.id.year)

        var deleteBtn: Button = itemView.findViewById(R.id.delete_btn)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDemoHolder {
        val inflater=LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_layout,
                parent,false)
        return MyDemoHolder(inflater)

    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder
                (holder: MyDemoHolder, position: Int)
    {
        val data=list[position]
        holder.title.text=data.getTitle()
        holder.general.text=data.getGenre()
        holder.year.text=data.getYear()

        holder.deleteBtn.setOnClickListener{
            holder.title.text = ""
            holder.general.text = ""
            holder.year.text =""
            list.removeAt(position)
            notifyDataSetChanged()
        }

    }

}