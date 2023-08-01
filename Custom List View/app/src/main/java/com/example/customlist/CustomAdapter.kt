package com.example.customlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.Objects

class CustomAdapter(context: Context, var resource: Int, var objects: MutableList<ContactDetails>) :
    ArrayAdapter<ContactDetails>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(context)
        val view: View=layoutInflater.inflate(resource, null)
        val imageView:ImageView=view.findViewById(R.id.image)
        val title: TextView =view.findViewById(R.id.text1)
        val description: TextView =view.findViewById(R.id.text2)
        val mItem:ContactDetails=objects[position]

        imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        title.text=mItem.title
        description.text=mItem.description
        return view


//        return super.getView(position, convertView, parent)
    }
}