package com.nicktra.moviesquare.ui.about

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*


class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = getString(R.string.about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*val item: MenuItem = bottomNav.menu.findItem(R.id.menu_info)
        item.isChecked = true*/
        bottomNav.selectedItemId = R.id.menu_info

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val moveAboutIntent = Intent(this@AboutActivity, HomeActivity::class.java)
                    startActivity(moveAboutIntent)
                    true
                }
                R.id.menu_favorite -> {
                    Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_info -> {
                    Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
//        val intent = Intent(this, HomeActivity::class.java)
//        startActivity(intent)
        val activity = intent.getStringExtra("activity")
        if (activity == "home"){
            bottomNav.selectedItemId = R.id.menu_home
        } else {
            bottomNav.selectedItemId = R.id.menu_favorite
        }
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}