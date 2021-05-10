package com.example.dounat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_data_pembeli.*
import kotlinx.android.synthetic.main.activity_struck.*

class struck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_struck)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val namaO = intent.getStringExtra("nama")
        val noO = intent.getStringExtra("noO")
        val almatO = intent.getStringExtra("almatO")
        val namap  = intent.getStringExtra("namap")
        val price  = intent.getIntExtra("price",0)
        val harga  = intent.getIntExtra("harga",0)

        actionBar.setTitle("Struck Belanja " + namaO)

        data1.text = namaO
        data2.text = noO.toString()
        data3.text = almatO
        c1.text = namap
        c2.text = price.toString()
        c3.text = harga.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}