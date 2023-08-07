package com.example.listview

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

class CartAdapeterDemo (context:Context,  var resource : Int, var objects: MutableList<CartDataModelClass>)
    :  ArrayAdapter<CartDataModelClass>(context, resource, objects)
{
    lateinit var cb:CheckBox
    fun isChecked(position: Int):Boolean{
        return objects.get(position).checked

    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource, null )
        val imageView: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.textView)
        val description: TextView = view.findViewById(R.id.textView2)
        val button: Button = view.findViewById(R.id.button)
         cb= view.findViewById(R.id.checkBox)
        val mItem:CartDataModelClass= objects[position]

        imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        title.text=mItem.title
        description.text=mItem.description
        button.tag= position
        cb.setTag(position)
        var itemStr = objects.get(position).title
        cb.setOnClickListener{
            val newState:Boolean =!objects.get(position).checked
            objects.get(position).checked = newState
            Toast.makeText(
                context,itemStr+"Selected with state  :"+newState ,Toast.LENGTH_LONG
            ).show()
        }
        cb.setChecked(isChecked(position))
        return view
       }
}