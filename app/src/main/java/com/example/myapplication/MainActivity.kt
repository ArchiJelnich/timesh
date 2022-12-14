package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MyTrack : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Add())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)


        var sharedPref : SharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        var DarkModeSwitched = sharedPref.getBoolean("DarkModeSwitched",false)
        var LangModeSwitched = sharedPref.getBoolean("LangModeSwitched",false)
        var thema_dark = sharedPref.getBoolean("thema_dark",false)
        var lang = sharedPref.getBoolean("lang",false)
        var editor = sharedPref.edit()





        if (DarkModeSwitched) {
            editor.putBoolean("DarkModeSwitched",false)
            loadFragment(Setting())
            true
        }

        if (LangModeSwitched) {

            editor.putBoolean("LangModeSwitched",false)

            if (lang) {
                setLocale("en")
            } else {
                setLocale("be")
            }
            loadFragment(Setting())
            true
        }

        if (thema_dark)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.Add -> {
                    loadFragment(Add())
                    true
                }

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

    fun setLocale(localeName: String) {

        lateinit var locale: Locale
        locale = Locale(localeName)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = locale
        res.updateConfiguration(conf, dm)



    }

}

