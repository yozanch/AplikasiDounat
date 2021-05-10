package com.example.dounat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_data_pembeli.*
import kotlinx.android.synthetic.main.activity_struck.*

class data_pembeli : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pembeli)


        val actionBar : androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)


        var intent = intent
        val namaP  = intent.getStringExtra("namap")
        val price  = intent.getIntExtra("qty",0)
        val harga  = intent.getIntExtra("tot",0)

        actionBar.setTitle("Data Pembeli")

        d1.text = namaP
        d2.text = price.toString()
        d3.text = harga.toString()


       val namaEt = findViewById<EditText>(R.id.namaEt)
       val noEt = findViewById<EditText>(R.id.noET)
       val alamatEt = findViewById<EditText>(R.id.alamatEt)
       val btnEt = findViewById<Button>(R.id.btnEt)


        btnEt.setOnClickListener{
            var nama = namaEt.text.toString()
            var noO = noEt.text.toString()
            var almatO = alamatEt.text.toString()

            val  intent  = Intent (this@data_pembeli,struck::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("noO", noO)
            intent.putExtra("almatO", almatO)
            intent.putExtra("namap",namaP)
            intent.putExtra("price",price)
            intent.putExtra("harga",harga)
            startActivity(intent)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}