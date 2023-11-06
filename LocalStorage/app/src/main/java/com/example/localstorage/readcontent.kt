package com.example.localstorage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.Externalizable
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

class readcontent : AppCompatActivity() {

    lateinit var fstream : FileInputStream
    private val filename = "Sample.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile: File

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readcontent)
        val result = findViewById<TextView>(R.id.et3)
        val back = findViewById<Button>(R.id.btn9)
        try {
            myExternalFile = File(getExternalFilesDir(filepath), filename)
            fstream = FileInputStream(myExternalFile)
            val sbuffer = StringBuilder()
            var i: Int
            while (fstream.read().also { i = it } != -1) {
                sbuffer.append(i.toChar())
            }
            fstream.close()
            val details = sbuffer.toString().split('\n').toTypedArray()
            result.text
            result.text = """
                Name : ${details[0]}
                Password : ${details[1]}
            """.trimIndent()
        }
        catch (e:FileNotFoundException){
            e.printStackTrace()
        }
        catch (e:IOException){
            e.printStackTrace()
        }
        back.setOnClickListener {
            intent = Intent(this,
                extranal_storage::class.java)
            startActivity(intent)
        }

        }
}