package com.example.asynctask

import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity2 : AppCompatActivity() {
    lateinit var ImageUrl:URL
    var `is` : InputStream? =null;
    var bmpImg : Bitmap? = null;
    lateinit var imageView: ImageView
//    lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button.onClickListner{
            val asyncTask: AsyncTaskExample = AsyncTaskExample()
            asyncTask.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg")
        }
        }
    }

    private inner class AsyncTaskExample: AsyncTask<String?, String?, Bitmap?>(){
        override fun doInBackground(vararg p0: String?): Bitmap?{
            try{
                ImageUrl = URL(p0[0])
                val conn: HttpURLConnection = ImageUrl.openConnection() as HttpURLConnection
                conn.setDoInput(true)
                conn.connect()
                `is` = conn.getInputStream

            }
        }

        override fun onPostExecute(bitmap: Bitmap?) {
            super.onPostExecute(bitmap)
            if (imageView != null){

            }
        }
    }

}