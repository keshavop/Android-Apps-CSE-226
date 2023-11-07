package com.example.floatingactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var add : FloatingActionButton
    lateinit var home : FloatingActionButton
    lateinit var setting : FloatingActionButton
    var fabvisibility : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add = findViewById(R.id.idFABAdd)
        home = findViewById(R.id.idFABHome)
        setting = findViewById(R.id.idFABSettings)
        fabvisibility = false
        add.setOnClickListener{
            if (!fabvisibility){
                setting.show()
                home.show()
                home.visibility = View.VISIBLE
                setting.visibility = View.VISIBLE
                add.setImageDrawable(resources.getDrawable(R.drawable.baseline_close_24))
                fabvisibility = true
            }
            else{
                setting.hide()
                home.hide()
                home.visibility = View.GONE
                setting.visibility = View.GONE
                add.setImageDrawable(resources.getDrawable(R.drawable.baseline_add_reaction_24))
                fabvisibility = false
            }

            home.setOnClickListener{
                Toast.makeText(this,"Clicked on Home",Toast.LENGTH_LONG).show()
            }

            setting.setOnClickListener{
                Toast.makeText(this,"Clicked on Setting",Toast.LENGTH_LONG).show()
            }
        }

    }
}