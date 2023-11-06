package com.example.localstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var b1 :Button
    lateinit var b2 : Button
    lateinit var et : EditText
    lateinit var tv : TextView

    var file = "myFile.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.btn1)
        b2 = findViewById(R.id.btn2)
        et = findViewById(R.id.edit1)
        tv = findViewById(R.id.text1)

        var data:String

        b1.setOnClickListener(){
            data = et.text.toString()
            try{
                val fout = openFileOutput(file, MODE_APPEND)
                fout.write(data.toByteArray())
                fout.close()
                Toast.makeText(this, "Data Saved in file", Toast.LENGTH_LONG).show()
            }
            catch(e: IOException){
                e.printStackTrace()
            }
        }

        b2.setOnClickListener() {
            try {
                val fin = openFileInput(file)
                var c: Int
                var temp = ""
                while (fin.read().also { c = it } != -1) {
                    temp += c.toChar().toString()
                }
                tv.text = temp
                fin.close()
                Toast.makeText(this, "Data saved in file", Toast.LENGTH_LONG).show()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}