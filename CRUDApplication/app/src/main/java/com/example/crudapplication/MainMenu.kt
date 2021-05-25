package com.example.crudapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val bundle = intent.extras
        val msg = bundle!!.getString("msg")
        val l =  bundle.getSerializable("Login") as User


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
/*            R.id.nav_jobapp -> {
                val i = Intent(this, CrudPersonas::class.java)
                startActivity(i)
            }
            R.id.nav_list -> {
                val i = Intent(this, CrudPersonas::class.java)
                startActivity(i)
            }*/
            R.id.nav_logout -> {
                val i = Intent(this, Login::class.java)
                startActivity(i)
            }
        }
        return true
    }
}