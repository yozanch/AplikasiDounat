package com.example.dounat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_product.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navDraweView : NavigationView

    private lateinit var bottomNavigation : BottomNavigationView

    var myAdapter : productAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayItem = ArrayList<product_model>()
        arrayItem.add(product_model("Donat Panggang","donat ini di panggang tidak digoreng",R.drawable.donat_panggang,15000))
        arrayItem.add(product_model("Donat Sapi","donat ini di balut dengan taburan daging sapi",R.drawable.donat_sapi,35000))
        arrayItem.add(product_model("Donat Ayam","donat ini di balut dengan taburan daging ayam",R.drawable.donat_ayam,25000))
        arrayItem.add(product_model("Donat Cabe","awas donat ini sangant pedas..!!!",R.drawable.donat_cabe,18000))
        arrayItem.add(product_model("Donat Rebus","donat ini tidak dianjurkan untuk dibeli",R.drawable.donat_rebus,5000))
        arrayItem.add(product_model("Donat Arab","donat ini langsung di import dari arab",R.drawable.donat_arab,150000))
        arrayItem.add(product_model("Donat Micin","donat ini bisa menyebabkan kebodohan akut",R.drawable.donat_micin,20000))
        arrayItem.add(product_model("Donat Lumer","donat ini sangat lumer di mulut",R.drawable.donat_lumer,50000))
        arrayItem.add(product_model("Donat Mars","donat yang merupakan oleh-oleh dari mars",R.drawable.donat_mars,15000000))

        myAdapter = productAdapter(this)
        myAdapter!!.setData(arrayItem)

        //Product_RecyclerView berasal dari id recyclerView pada activity_main.xml
        product_RecycleView.layoutManager = LinearLayoutManager(this)
        product_RecycleView.adapter       = myAdapter

        bottomNavigation = findViewById(R.id.navbottom)
        bottomNavigation.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.home -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.history -> {
                    Toast.makeText(this, "Go to History", Toast.LENGTH_SHORT)
                    true
                }
                else -> {
                    false
                }
            }
        }

        drawerLayout = findViewById(R.id.drawer)

        actionBarToggle = ActionBarDrawerToggle (this, drawerLayout,0,0)

        drawerLayout.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        actionBarToggle.syncState()

        navDraweView = findViewById(R.id.navdrawer)
        navDraweView.setNavigationItemSelectedListener {  menuItem ->
            when(menuItem.itemId){
                R.id.profile ->{
                   val intent = Intent(applicationContext, profile_perusahaan :: class.java)
                    startActivity(intent)
                    true
                }
                R.id.contact ->{
                    val intent = Intent(applicationContext, contack :: class.java)
                    startActivity(intent)
                    true

            }
                R.id.help ->{
                    Toast.makeText(this,"go to helper",
                            Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            this.drawerLayout.openDrawer((GravityCompat.START))
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val searchItem = menu?.findItem(R.id.search)
        if (searchItem != null){
            val searchView = searchItem.actionView as SearchView
            searchView.maxWidth = Int.MAX_VALUE
            searchView.setOnQueryTextListener(object :
                SearchView.OnQueryTextListener{
                     override fun onQueryTextSubmit(p0: String?): Boolean {
                        return true
                }

                    override fun onQueryTextChange(filterString : String?): Boolean {
                        return true
                }
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.shoping){
            Toast.makeText(this,"View Shopping",Toast.LENGTH_SHORT).show()
            return true
        }else if (id == R.id.account) {
            val intent = Intent(applicationContext, profile :: class.java)
            startActivity(intent)
            true
        }else if (id == R.id.login) {
            val intent = Intent(applicationContext, login :: class.java)
            startActivity(intent)
            true
        }else if (id == R.id.logout) {
            val intent = Intent(applicationContext, login :: class.java)
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            true
        }
        return super.onOptionsItemSelected(item)
    }
}

