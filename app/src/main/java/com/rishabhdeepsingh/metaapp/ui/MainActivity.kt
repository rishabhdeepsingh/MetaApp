package com.rishabhdeepsingh.metaapp.ui

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.rishabhdeepsingh.metaapp.R
import com.rishabhdeepsingh.metaapp.ui.chillzone.chillZoneFragment


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            navView.setCheckedItem(R.id.home)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
            }
            R.id.nav_chillzone -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, chillZoneFragment())
                    .commit()
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
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
