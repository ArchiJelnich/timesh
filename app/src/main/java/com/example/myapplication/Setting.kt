package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_setting.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Setting.newInstance] factory method to
 * create an instance of this fragment.
 */
class Setting : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        var editor = sharedPref.edit()
        var lang = sharedPref.getBoolean("lang",false)
        var thema_dark = sharedPref.getBoolean("thema_dark",false)
        var ask = sharedPref.getBoolean("ask",false)

        editor.putBoolean("DarkModeSwitched",false)
        editor.putBoolean("LangModeSwitched",false)



        editor.commit()




        switch_lang.setChecked(lang)
        switch_thema.setChecked(thema_dark)
        switch_ask.setChecked(ask)


        switch_lang.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            // do something, the isChecked will be
            // true if the switch is in the On position


            editor.putBoolean("lang",isChecked)
            editor.putBoolean("DarkModeSwitched",true)
            editor.commit()



            if (isChecked && !lang) {
                setLocale("en")
            } else if (lang){
                setLocale("ru")
            }




        })

        switch_thema.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            // do something, the isChecked will be
            // true if the switch is in the On position

            editor.putBoolean("LangModeSwitched",false)
            editor.putBoolean("thema_dark",isChecked)
            editor.commit()

            Log.v("MyLog", "Theme changed")

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }


        })

        switch_ask.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            // do something, the isChecked will be
            // true if the switch is in the On position

            editor.putBoolean("ask",isChecked)
            editor.commit()
        })

        add_del.setOnClickListener(){
            val builder = AlertDialog.Builder(context)
            builder.setTitle(R.string.setting_confirm)
            builder.setMessage(R.string.setting_deleteall)
            //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(R.string.yes) { _, _ ->
                sharedPref.edit().clear().commit();
                val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "calendar").allowMainThreadQueries().build() //MUST BE REFACTOR TO THREAD!!!
                val calendarDao = db.calendarDao()
                calendarDao.deleteAll()

            }

            builder.setNegativeButton(R.string.no) { _, _ ->

            }

            builder.show()



        }


    }

    fun setLocale(localeName: String) {

        lateinit var locale: Locale
        locale = Locale(localeName)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = locale
        res.updateConfiguration(conf, dm)

        activity?.let{
            val intent = Intent (it, MyTrack::class.java)
            it.startActivity(intent)


        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Setting.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Setting().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
