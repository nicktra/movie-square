package com.nicktra.moviesquare.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.ui.about.AboutActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
        supportActionBar?.elevation = 0f

        /*val item: MenuItem = bottomNav.menu.findItem(R.id.menu_home)
        item.isChecked = true*/
        bottomNav.selectedItemId = R.id.menu_home

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_favorite -> {
                    Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_info -> {
                    val moveAboutIntent = Intent(this, AboutActivity::class.java)
                    moveAboutIntent.putExtra("activity","home");
                    startActivity(moveAboutIntent)
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveAboutIntent = Intent(this@HomeActivity, AboutActivity::class.java)
                startActivity(moveAboutIntent)

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /*override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }*/
}