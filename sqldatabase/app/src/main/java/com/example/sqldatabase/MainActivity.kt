package com.example.sqldatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addName : Button = findViewById(R.id.post)
        val printName : Button = findViewById(R.id.fetch)

        val enterName : EditText = findViewById(R.id.name)
        val enterAge : EditText = findViewById(R.id.age)

        val Name : TextView = findViewById(R.id.showName)
        val Age : TextView = findViewById(R.id.showAge)

        val deleteDetail : TextView = findViewById(R.id.detele)

        addName.setOnClickListener{
            val db = DBHelper(this, null)

            val name = enterName.text.toString()
            val age = enterAge.text.toString()

            db.addName(name,age)
            Toast.makeText(this,name + " added to database ", Toast.LENGTH_SHORT).show()

            enterName.text.clear()
            enterAge.text.clear()

        }

        printName.setOnClickListener{
            val db = DBHelper(this, null)
            val cursor = db.getName()
            Name.text="Name\n\n"
            Age.text="Age\n\n"
            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl))
                    + "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL))
                    + "\n")
            while(cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex
                    (DBHelper.NAME_COl)) + "\n")
                Age.append(cursor.getString
                    (cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
            }
            cursor.close()
        }

//        updateName.setOnClickListner{
//            val dbHandler = DBHelper(this, null)
//            dbHandler.updateCourse(
//                dbHandler.updateCourse(
//                    enterName.getText
//                )
//            )
//        }

        deleteDetail.setOnClickListener{
            val dbHandler = DBHelper(this, null)
            dbHandler.deleteDetail(enterAge.getText().toString())
            Toast.makeText(this@MainActivity, "Data Deleted", Toast.LENGTH_SHORT).show()
        }
    }
}