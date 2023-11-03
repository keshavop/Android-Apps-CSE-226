package com.example.customlistviewcart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_demo)
        var list = mutableListOf<CartAdapter>()
        var listView = findViewById<ListView>(R.id.ListView)
        var bt1 = findViewById<Button>(R.id.b1)
        var p = 0
        list.add(CartAdapter("Phone", "Friend", R.drawable.ic_launcher_background, false))
        list.add(CartAdapter("Watch", "Friend", R.drawable.ic_launcher_foreground, false))
        list.add(CartAdapter("Earpods", "Cousin", R.drawable.ic_launcher_background, false))
        list.add(CartAdapter("Earph", "Cousin", R.drawable.ic_launcher_background, false))
        listView.adapter = CartDemo(this, R.layout.card_demo, list)

        bt1.setOnClickListener {
            var str = "Check items:\n";
            val cnt: Int = list.count()
            for (i in 0 until cnt) {
                var  a = CartDemo(this, R.layout.card_demo, list)
                if (a.isChecked(i)) {
                    str += """$i """.trimIndent()
                }
            }
            Toast.makeText(this,
                str,
                Toast.LENGTH_LONG).show();
        }
    }
}