package com.example.grid_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<GridModel>
    lateinit var rv:RecyclerView
    var adap:GridViewAdapter? = null

    lateinit var edit:EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recyclerView)
        edit =findViewById(R.id.editText)
        btn = findViewById(R.id.button)

        call()
        rv.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(
            this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        rv.layoutManager = gridLayoutManager
        adap = GridViewAdapter(this, list)
        rv.adapter = adap
    }
    fun call() {
        list = ArrayList<GridModel>()
        list.add(GridModel("Apple", R.drawable.apple))
        list.add(GridModel("Oranges", R.drawable.orange))
        list.add(GridModel("PomoGranate", R.drawable.pomogranate))
        list.add(GridModel("PineApple", R.drawable.pineapple))
        list.add(GridModel("Strawberries", R.drawable.strawberries))
        list.add(GridModel("BlueBerry", R.drawable.blueberry))

        val txt = edit.text.toString()
        btn.setOnClickListener{
            list.add(GridModel("$txt", R.drawable.apple))
        }
    }
}