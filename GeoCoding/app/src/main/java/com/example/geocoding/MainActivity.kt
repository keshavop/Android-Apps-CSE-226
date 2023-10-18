package com.example.geocoding

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etAddress: EditText
    lateinit var latitude: TextView
    lateinit var longitude: TextView
    lateinit var findbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAddress = findViewById(R.id.editTextText)
        findbtn = findViewById(R.id.button)
        latitude = findViewById(R.id.textView3)
        longitude = findViewById(R.id.textView2)

        findbtn.setOnClickListener{
            if (etAddress.text.toString().isEmpty()){
               Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show()
                }
            else{
                getLocationFromAddress(etAddress.text.toString())
            }
        }
    }

    private fun getLocationFromAddress(location: String){
        val geocoder = Geocoder(this)
        val list: List<Address> = geocoder.getFromLocationName(location, 5)!!
        if (list.isNullOrEmpty()){
            return
        }
        latitude.text = "Latitude\n ${list[0].latitude}"
        longitude.text = "Longitude\n ${list[0].longitude}"

    }
}