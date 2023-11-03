package com.example.customlistviewcart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class CartDemo (context: Context,var resource: Int,
                var objects: MutableList<CartAdapter>) :
    ArrayAdapter<CartAdapter>(context, resource, objects) {
    lateinit var cb:CheckBox
    fun isChecked(position: Int): Boolean {
        return objects.get(position).checked
    }
    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource, null)
        val imageView: ImageView = view.findViewById(R.id.i)
        val title: TextView = view.findViewById(R.id.textView1)
        val description: TextView = view.findViewById(R.id.textView2)
        val button: Button = view.findViewById(R.id.Delete)

        val mItem: CartAdapter = objects.get(position)
        imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        title.text = mItem.title
        description.text = mItem.description
        button.tag=position
        cb=view.findViewById<CheckBox>(R.id.checkBox)
        cb.setChecked(objects.get(position).checked)
        cb.setTag(position)
        var itemStr = objects.get(position).title;
        cb.setOnClickListener(View.OnClickListener {
            val newState: Boolean = !objects.get(position).isChecked()
            objects.get(position).checked = newState
            Toast.makeText(
                context,itemStr+
                        "Selected with state   : "+newState ,
                Toast.LENGTH_LONG
            ).show()
        })
        cb.setChecked(isChecked(position))

        return view
    }



}