package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Categ())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)


        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.Settings -> {
                    loadFragment(Setting())
                    true
                }
                R.id.Category -> {
                    loadFragment(Categ())
                    true
                }
                R.id.Graph -> {
                    loadFragment(Grath())
                    true
                }
                R.id.Add -> {
                    loadFragment(Add())
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
