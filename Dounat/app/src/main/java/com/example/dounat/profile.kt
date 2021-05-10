package com.example.dounat

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

       val actionBar : androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        actionBar.setTitle("My Profile")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}