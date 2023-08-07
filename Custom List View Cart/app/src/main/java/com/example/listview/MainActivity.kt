package com.example.listview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listview: ListView = findViewById(R.id.list_item)
        val btn:Button= findViewById(R.id.button2)
       val list =  mutableListOf<CartDataModelClass>()
        list.add(CartDataModelClass("kiki", "me", com.google.android.material.R.drawable.abc_ic_arrow_drop_right_black_24dp, false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.btn_checkbox_checked_mtrl,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
        list.add(CartDataModelClass("keshav", "Family", com.google.android.material.R.drawable.ic_m3_chip_check,false))
       listview.adapter= CartAdapeterDemo(this, R.layout.customlook,list )

        btn.setOnClickListener {
            var str = "Check Items: \n";
            val ctn : Int = list.count()
            for (i in 0 until ctn) {
                var a = CartAdapeterDemo(this, R.layout.customlook, list)
                if(a.isChecked(i)){
                    str += """$i
                        |
                    """.trimIndent()
                }
            }
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }

    }
}