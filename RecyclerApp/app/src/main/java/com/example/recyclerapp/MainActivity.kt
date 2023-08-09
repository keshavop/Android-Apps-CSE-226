package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var adap:RecyclerAdapterDemo
    var list = ArrayList<MyDataModel1>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager =LinearLayoutManager(applicationContext)
        rv.layoutManager = (layoutManager)
        rv.itemAnimator = DefaultItemAnimator()
        adap = RecyclerAdapterDemo(list)
        rv.adapter = adap
        call()
    }
    fun call(){
        list.add(MyDataModel1("Sem-1","CGPA:8.44","2020"))
        list.add(MyDataModel1("Sem-2","CGPA:8.32","2021"))
        list.add(MyDataModel1("Sem-3","CGPA:7.84","2021"))
        list.add(MyDataModel1("Sem-4","CGPA:8.23","2022"))
        list.add(MyDataModel1("Sem-5","CGPA:8","2022"))
        list.add(MyDataModel1("Sem-6","CGPA:8.32","2023"))
        list.add(MyDataModel1("Sem-7","CGPA:9","2023"))
        list.add(MyDataModel1("Sem-8","CGPA:10","2024"))

        adap.notifyDataSetChanged()
    }
}