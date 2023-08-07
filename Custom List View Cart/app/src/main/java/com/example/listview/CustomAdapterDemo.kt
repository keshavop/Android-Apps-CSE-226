package com.example.listview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomAdapterDemo(
    context: Context,
     var resource: Int,
   var objects: MutableList<ContactDataModelClass>
) :
    ArrayAdapter<ContactDataModelClass>(context, resource, objects) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view:View = layoutInflater.inflate(resource, null )
        val imageView:ImageView = view.findViewById(R.id.image)
        val title:TextView = view.findViewById(R.id.textView)
        val description:TextView = view.findViewById(R.id.textView2)
        val button: Button = view.findViewById(R.id.button)
        val mItem:ContactDataModelClass= objects[position]

imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
title.text=mItem.title
        description.text=mItem.description
        button.tag= position


        button.setOnClickListener {
            val itemSelected = objects.get(button.tag as Int)
            objects.remove(itemSelected)
            notifyDataSetChanged()
        }


        return view
    }

}