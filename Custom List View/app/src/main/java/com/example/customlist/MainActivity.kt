package com.example.customlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView:ListView = findViewById(R.id.listview)
        val List = mutableListOf<ContactDetails>()
        List.add(ContactDetails("NA", "Friend", R.drawable.ic_launcher_background))
        List.add(ContactDetails("Keshav", "Me", R.drawable.ic_launcher_background))
        List.add(ContactDetails("Aman", "Brother", R.drawable.ic_launcher_background))
        List.add(ContactDetails("Bonny", "Foe", R.drawable.ic_launcher_background))
        List.add(ContactDetails("Mrinal", "Friend", R.drawable.ic_launcher_background))

        listView.adapter = CustomAdapter(this, R.layout.custom_list,List)


    }


}