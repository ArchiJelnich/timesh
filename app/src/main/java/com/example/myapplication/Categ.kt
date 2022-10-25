package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_categ.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [Categ.newInstance] factory method to
 * create an instance of this fragment.
 */
class Categ : Fragment() {
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
        return inflater.inflate(R.layout.fragment_categ, container, false)
    }


    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val mySet = setOf("Red", "Orange", "Yellow", "Green", "Blue", "Dark Blue", "Purple", "Pink",  "Black", "Grey")

        var sharedPref: SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        var editor = sharedPref.edit()
        var red = sharedPref.getString("red", "Red")
        var orange = sharedPref.getString("orange", "Orange")
        var yellow = sharedPref.getString("yellow", "Yellow")
        var green = sharedPref.getString("green", "Green")
        var blue = sharedPref.getString("blue", "Blue")
        var d_blue = sharedPref.getString("d_blue", "Dark Blue")
        var purple = sharedPref.getString("purple", "Purple")
        var pink = sharedPref.getString("pink", "Pink")
        var black = sharedPref.getString("black", "Black")
        var grey = sharedPref.getString("grey", "Grey")

        /* if (mySet.contains(red)) { red_tv.setTextColor(R.color.white)} else {red_tv.setTextColor(R.color.black)}
        if (mySet.contains(orange)) { orange_tv.setTextColor(R.color.white)} else {orange_tv.setTextColor(R.color.black)}
        if (mySet.contains(yellow)) { yellow_tv.setTextColor(R.color.white)} else {yellow_tv.setTextColor(R.color.black)}
        if (mySet.contains(green)) { green_tv.setTextColor(R.color.white)} else {green_tv.setTextColor(R.color.black)}
        if (mySet.contains(blue)) { blue_tv.setTextColor(R.color.white)} else {blue_tv.setTextColor(R.color.black)}
        if (mySet.contains(d_blue)) { d_blue_tv.setTextColor(R.color.white)} else {d_blue_tv.setTextColor(R.color.black)}
        if (mySet.contains(purple)) { purple_tv.setTextColor(R.color.white)} else {purple_tv.setTextColor(R.color.black)}
        if (mySet.contains(pink)) { pink_tv.setTextColor(R.color.white)} else {pink_tv.setTextColor(R.color.black)}
        if (mySet.contains(black)) { black_tv.setTextColor(R.color.white)} else {black_tv.setTextColor(R.color.black)}
        if (mySet.contains(grey)) { grey_tv.setTextColor(R.color.white)} else {grey_tv.setTextColor(R.color.black)}
*/
        red_tv.setText(red)
        orange_tv.setText(orange)
        yellow_tv.setText(yellow)
        green_tv.setText(green)
        blue_tv.setText(blue)
        d_blue_tv.setText(d_blue)
        purple_tv.setText(purple)
        pink_tv.setText(pink)
        black_tv.setText(black)
        grey_tv.setText(grey)

        red_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("red", SanitizeString(s)).commit()
            }
        })
        orange_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("orange", SanitizeString(s)).commit()
            }
        })
        yellow_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("yellow", SanitizeString(s)).commit()
            }
        })
        green_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("green", SanitizeString(s)).commit()
            }
        })
        blue_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("blue", SanitizeString(s)).commit()
            }
        })
        d_blue_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("d_blue", SanitizeString(s)).commit()
            }
        })
        purple_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("purple", SanitizeString(s)).commit()
            }
        })
        pink_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("pink", SanitizeString(s)).commit()
            }
        })
        black_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("black", SanitizeString(s)).commit()
            }
        })
        grey_tv.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                editor.putString("grey", SanitizeString(s)).commit()
            }
        })


        //editor.putBoolean("nightModeSwitched",false)
        //editor.commit()


    }

    fun SanitizeString(s: Editable): String {
        var s_st = s.toString()
        val s_chars: Array<Char> = s_st.toCharArray().toTypedArray()
        var s_new = ""
        val s_w="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ1234567890"

        for (char in s_chars) {
            if(s_w.contains(char))
            {
                s_new += char
                Log.v("MyLog", "Checking " + char)
            }

            Toast.makeText(requireContext(), "Special characters will be deleted", Toast.LENGTH_SHORT).show()

        }


        return s_new
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Categ.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Categ().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}