package com.example.brodcastreceiverjobservice

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    var jobScheduler : JobScheduler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stopJob = findViewById<Button>(R.id.button2)
        val startJob = findViewById<Button>(R.id.button)

        startJob.setOnClickListener{
            jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName = ComponentName(this, JobServiceDemo::class.java)
            val builder = JobInfo.Builder(123, componentName)
            builder.setMinimumLatency(1000)
            builder.setOverrideDeadline(5000)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }

        stopJob.setOnClickListener{
            if(jobScheduler != null){
                jobScheduler!!.cancel(123)
                jobScheduler = null
                Toast.makeText(this, "Job cancelled",Toast.LENGTH_LONG).show()
            }
        }
    }
}