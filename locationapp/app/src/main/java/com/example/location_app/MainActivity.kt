package com.example.location_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var latitude: TextView
    lateinit var longitude:TextView
    lateinit var locality:TextView
    lateinit var address:TextView
    lateinit var country:TextView
    lateinit var getLocation: Button

    private  lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    private  val permissionId = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        latitude = findViewById(R.id.textView3)
        longitude = findViewById(R.id.textView4)
        locality = findViewById(R.id.textView5)
        address = findViewById(R.id.textView6)
        country = findViewById(R.id.textView7)
        getLocation = findViewById(R.id.button)

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        getLocation.setOnClickListener {
            getLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private  fun getLocation() {
        if(checkPermissions()) {
            if(isLoctionEnabled()) {
                mFusedLocationProviderClient.lastLocation.addOnSuccessListener {
                        location: Location? ->
                    location?.let {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val list: List<Address> = geocoder.getFromLocation(location.latitude, location.longitude, 1)!!

                        latitude.text = "Latitude\n ${list[0].latitude}"
                        longitude.text = "Longitude\n ${list[0].longitude}"
                        country.text = "Country Name\n ${list[0].countryName}"
                        locality.text = "Locality\n${list[0].getAddressLine(0)}"
                    }
                }
            }
            else {
                Toast.makeText(this, "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }
        else {
            requestPermissions()
        }
    }
    private fun isLoctionEnabled():Boolean {
        val locationManager:LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun checkPermissions():Boolean {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION),permissionId)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == permissionId){
            if((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                getLocation()
            }
        }
    }
}