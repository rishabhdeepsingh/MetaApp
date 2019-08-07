package com.rishabhdeepsingh.metaapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.rishabhdeepsingh.metaapp.R
import com.rishabhdeepsingh.metaapp.ui.chillzone.ChillZoneActivity


open class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navView: NavigationView
    private val LOG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(LOG, "\n[~~] MainActivity.onCreate() Done")

        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        mDrawerLayout = findViewById(R.id.main_drawer_layout)

        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, mDrawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame_layout, HomeFragment())
                .commit()
            navView.setCheckedItem(R.id.nav_home)
        }
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {

            }
            R.id.nav_chillzone -> {
                val intent = Intent(this, ChillZoneActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_share -> {
                Toast.makeText(this, "$LOG.Share", Toast.LENGTH_SHORT).show()
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
