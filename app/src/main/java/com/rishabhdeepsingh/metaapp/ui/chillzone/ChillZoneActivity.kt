package com.rishabhdeepsingh.metaapp.ui.chillzone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.rishabhdeepsingh.metaapp.R
import com.rishabhdeepsingh.metaapp.ui.MainActivity

class ChillZoneActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val CLASS = ChillZoneActivity::class.toString()
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chillzone_main)
        Log.d(CLASS, "[~~~] onCreate() Started")
        Toast.makeText(this, "This is a Toast", Toast.LENGTH_SHORT).show()

        val toolbar: Toolbar = findViewById(R.id.chillzone_toolbar)
        setSupportActionBar(toolbar)

        val navView: NavigationView = findViewById(R.id.nav_view_chillzone)

        mDrawerLayout = findViewById(R.id.chillzone_drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, mDrawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        bottomNavigationView = findViewById(R.id.bottom_nav_view)

        Toast.makeText(this, "ChillzoneActivity", Toast.LENGTH_SHORT).show()
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.chillzone_fragment, TodayFragment())
                .commit()
            navView.setCheckedItem(R.id.nav_chillzone)
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.setNavigationItemSelectedListener(this)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        Log.i(CLASS, "[X] Bottom NAV Listener Activated")
        lateinit var selectedFragment: Fragment
        when (item.itemId) {
            R.id.navigation_today -> {
                Log.i(CLASS, "[~~] Nav TODAY selected")
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                selectedFragment = TodayFragment()
            }
            R.id.navigation_dashboard -> {
                Log.i(CLASS, "[~~] Nav Dashboard selected")
                selectedFragment = ClassesFragment()
            }
            R.id.navigation_notifications -> {
                Log.i(CLASS, "[~~] Nav Notifications selected")
                Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.chillzone_fragment, selectedFragment)
            .commit()
        true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_view_chillzone -> {
                Toast.makeText(this, "ChillZone", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_send -> {

            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
