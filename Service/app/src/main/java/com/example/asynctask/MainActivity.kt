package com.example.asynctask

import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import java.net.HttpURLConnection

class MainActivity : AppCompatActivity() {
    var ar = arrayOf("1", "2", "3", "4", "5", "6")
    lateinit var pb: ProgressBar
    lateinit var lv: ListView
    lateinit var ad :ArrayAdapter<String>
    lateinit var al : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pb = findViewById(R.id.pb)
        lv = findViewById(R.id.lv)

        al = ArrayList()
        ad = ArrayAdapter(this, android.R.layout.simple_list_item_1, al)
        lv.adapter = ad
        MyTaskDemo().execute()
    }
    internal inner class  MyTaskDemo:AsyncTask<Void?,Int?, String?>() {
        var count = 0
        override fun doInBackground(vararg p0: Void?): String? {
            for(i in 1 .. 10) {
                count = count +1
                publishProgress(i)
            }
            try {
                Thread.sleep(1000)
            }
            catch (e:java.lang.Exception) {
                e.printStackTrace()
            }
            return "Task Completed"
        }

        override fun onPreExecute() {
            super.onPreExecute()
            pb.max = 10
            pb.progress = 0
            pb.visibility = View.VISIBLE
            count = 0
        }

        override fun onProgressUpdate(vararg values: Int?) {
            pb.progress = values[0]!!
            al.add(ar[count-1])
            ad.notifyDataSetChanged()
        }

        override fun onPostExecute(result: String?) {
            Toast.makeText(this@MainActivity,result, Toast.LENGTH_SHORT).show()
        }

    }


}