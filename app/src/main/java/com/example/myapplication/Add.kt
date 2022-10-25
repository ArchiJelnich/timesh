package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.room.Room
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.android.synthetic.main.fragment_add.*
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter.BASIC_ISO_DATE


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Add.newInstance] factory method to
 * create an instance of this fragment.
 */
class Add : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var cat_to_add = "red"
    var current = "2020-01-01"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(activity);
        current = LocalDateTime.now().format(BASIC_ISO_DATE)
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
        return inflater.inflate(R.layout.fragment_add, container, false)
    }



    @SuppressLint("ServiceCast", "ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "calendar").allowMainThreadQueries().build() //MUST BE REFACTOR TO THREAD!!!
        val calendarDao = db.calendarDao()
        calendarDao.findByDate(current)?. let {

        var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        cat_tv.text = sharedPref.getString("red","Red")



            //Log.v("MyLog", "newDate " + newDate)
            //calendarDao.insertAll(newDate)
            //var calend_id = calendarDao.findByDate("Hi")
            //Log.v("MyLog", "calend_id " + calend_id)
            //Log.v("MyLog", "Loaded summ" + calend_id.summ)

            //val dates: List<Calendar> = calendarDao.getAll()
            //Log.v("MyLog", "Not null")
            Log.v("MyLog", "Gotcha!")

        } ?: let {

            val newDate = Calendar(current, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            calendarDao.insertAll(newDate)
        }

        Log.v("MyLog", "All " + calendarDao.getAll())
        Log.v("MyLog", "All " + calendarDao.findByDate(current).date)


        //val newDate = Calendar("Hi", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10)
        //Log.v("MyLog", "newDate " + newDate)
        //calendarDao.insertAll(newDate)
        //var calend_id = calendarDao.findByDate("Hi")
        //Log.v("MyLog", "calend_id " + calend_id)
        //Log.v("MyLog", "Loaded summ" + calend_id.summ)
        //Log.v("MyLog", "All " + calendarDao.getAll())
        //val dates: List<Calendar> = calendarDao.getAll()


        up.setOnClickListener { onClick(up, null) }
        down.setOnClickListener { onClick(down, null) }
        add_but.setOnClickListener { onClick(add_but, null) }

        // Button click listener
        cat_iv.setOnClickListener {
            // Initialize a new layout inflater instance

            //val inflater: LayoutInflater = context?.getSystemService( Context.CONNECTIVITY_SERVICE ) as LayoutInflater

            val inflater = LayoutInflater.from(getActivity());
            num_add.text = "1"


            // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.cat_popup, null)

            // Initialize a new instance of popup window
            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                ConstraintLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                ConstraintLayout.LayoutParams.WRAP_CONTENT // Window height
            )

            // Set an elevation for the popup window
            popupWindow.elevation = 10.0F

            // Slide animation for popup window enter transition
            val slideIn = Slide()
            slideIn.slideEdge = Gravity.TOP
            popupWindow.enterTransition = slideIn

            // Slide animation for popup window exit transition
            val slideOut = Slide()
            slideOut.slideEdge = Gravity.END
            popupWindow.exitTransition = slideOut
            popupWindow.isFocusable = true;



            var red = view.findViewById<ImageView>(R.id.red_iv)
            red.setOnClickListener { onClick(red, popupWindow) }

            var orange = view.findViewById<ImageView>(R.id.orange_iv)
            orange.setOnClickListener { onClick(orange, popupWindow) }

            var green = view.findViewById<ImageView>(R.id.green_iv)
            green.setOnClickListener { onClick(green,popupWindow) }

            var blue = view.findViewById<ImageView>(R.id.blue_iv)
            blue.setOnClickListener { onClick(blue,popupWindow) }

            var d_blue = view.findViewById<ImageView>(R.id.d_blue_iv)
            d_blue.setOnClickListener { onClick(d_blue,popupWindow) }

            var purple = view.findViewById<ImageView>(R.id.purple_iv)
            purple.setOnClickListener { onClick(purple,popupWindow) }

            var pink = view.findViewById<ImageView>(R.id.pink_iv)
            pink.setOnClickListener { onClick(pink,popupWindow) }

            var yellow = view.findViewById<ImageView>(R.id.yellow_iv)
            yellow.setOnClickListener { onClick(yellow,popupWindow) }

            var black = view.findViewById<ImageView>(R.id.black_iv)
            black.setOnClickListener { onClick(black,popupWindow) }

            var grey = view.findViewById<ImageView>(R.id.grey_iv)
            grey.setOnClickListener { onClick(grey,popupWindow) }

            var red_tv = view.findViewById<TextView>(R.id.red_tv)
            var orange_tv = view.findViewById<TextView>(R.id.orange_tv)
            var yellow_tv = view.findViewById<TextView>(R.id.yellow_tv)
            var green_tv = view.findViewById<TextView>(R.id.green_tv)
            var blue_tv = view.findViewById<TextView>(R.id.blue_tv)
            var d_blue_tv = view.findViewById<TextView>(R.id.d_blue_tv)
            var pink_tv = view.findViewById<TextView>(R.id.pink_tv)
            var purple_tv = view.findViewById<TextView>(R.id.purple_tv)
            var black_tv = view.findViewById<TextView>(R.id.black_tv)
            var grey_tv = view.findViewById<TextView>(R.id.grey_tv)

            var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

            red_tv.text = sharedPref.getString("red","Red")
            orange_tv.text = sharedPref.getString("orange","Orange")
            yellow_tv.text = sharedPref.getString("yellow","Yellow")
            green_tv.text = sharedPref.getString("green","Green")
            blue_tv.text = sharedPref.getString("blue","Blue")
            d_blue_tv.text = sharedPref.getString("d_blue","Dark Blue")
            purple_tv.text = sharedPref.getString("purple","Purple")
            pink_tv.text = sharedPref.getString("pink","Pink")
            black_tv.text = sharedPref.getString("black","Black")
            grey_tv.text = sharedPref.getString("grey","Grey")



            /*
            red_iv.setOnClickListener { onClick(red_iv) }
            orange_iv.setOnClickListener { onClick(orange_iv) }
            green_iv.setOnClickListener { onClick(green_iv) }
            blue_iv.setOnClickListener { onClick(blue_iv) }
            d_blue_iv.setOnClickListener { onClick(d_blue_iv) }
            purple_iv.setOnClickListener { onClick(purple_iv) }
            pink_iv.setOnClickListener { onClick(pink_iv) }
            yellow_iv.setOnClickListener { onClick(yellow_iv) }
            black_iv.setOnClickListener { onClick(black_iv) }
            grey_iv.setOnClickListener { onClick(grey_iv) }
*/


            /* Set click listener for popup window's text view
            tv.setOnClickListener{
                // Change the text color of popup window's text view
                tv.setTextColor(Color.parseColor("#3EB489"))
            }




            //Set a click listener for popup's button widget
            buttonPopup.setOnClickListener{
                // Dismiss the popup window
                popupWindow.dismiss()
            }
*/

            // Set a dismiss listener for popup window
            popupWindow.setOnDismissListener {
                popupWindow.dismiss()
            }

            // Finally, show the popup window on app


            TransitionManager.beginDelayedTransition(root_l)
            popupWindow.showAtLocation(
                root_l, // Location to display popup window
                Gravity.CENTER, // Layout position to display popup
                0, // X offset
                0 // Y offset
            )




        }




    }




    @SuppressLint("ResourceAsColor")
    fun onClick(v: View, popupWindow: PopupWindow?) {

        val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "calendar").allowMainThreadQueries().build() //MUST BE REFACTOR TO THREAD!!!
        val calendarDao = db.calendarDao()

        when (v.id) {
            R.id.red_iv -> {

                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("red","Red"))
                cat_iv.setColorFilter(resources.getColor(R.color.red), PorterDuff.Mode.SRC_IN)
                cat_to_add = "red"


            }
            R.id.orange_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("orange","Orange"))
                cat_iv.setColorFilter(resources.getColor(R.color.orange), PorterDuff.Mode.SRC_IN)
                cat_to_add = "orange"

            }
            R.id.yellow_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("yellow","Yellow"))
                cat_iv.setColorFilter(resources.getColor(R.color.yellow), PorterDuff.Mode.SRC_IN)
                cat_to_add = "yellow"
            }
            R.id.green_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("green","Green"))
                cat_iv.setColorFilter(resources.getColor(R.color.green), PorterDuff.Mode.SRC_IN)
                cat_to_add = "green"
            }
            R.id.blue_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("blue","Blue"))
                cat_iv.setColorFilter(resources.getColor(R.color.blue), PorterDuff.Mode.SRC_IN)
                cat_to_add = "blue"

               /* cat_iv.clearColorFilter()
                DrawableCompat.setTint(
                    DrawableCompat.wrap(cat_iv.drawable),
                    R.color.blue
                );
                Log.v("MyLog", "Changed color");


                */
            }
            R.id.d_blue_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("d_blue","Dark Blue"))
                cat_iv.setColorFilter(resources.getColor(R.color.d_blue), PorterDuff.Mode.SRC_IN)
                cat_to_add = "d_blue"
            }
            R.id.purple_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("purple","Purple"))
                cat_iv.setColorFilter(resources.getColor(R.color.purple), PorterDuff.Mode.SRC_IN)
                cat_to_add = "purple"
            }
            R.id.pink_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("pink","Pink"))
                cat_iv.setColorFilter(resources.getColor(R.color.pink),PorterDuff.Mode.SRC_IN)
                cat_to_add = "pink"


            }
            R.id.grey_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("grey","Grey"))
                cat_iv.setColorFilter(resources.getColor(R.color.grey), PorterDuff.Mode.SRC_IN)
                cat_to_add = "grey"
            }
            R.id.black_iv -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                cat_tv.setText(sharedPref.getString("black","Black"))
                cat_iv.setColorFilter(resources.getColor(R.color.black), PorterDuff.Mode.SRC_IN)
                cat_to_add = "black"


            }

            R.id.up -> {
                var countiint = num_add.text.toString().toInt() + 1
                num_add.text = countiint.toString()
            }
            R.id.down -> {

                if (num_add.text.toString().toInt()>0)
                {
                    var countiint = num_add.text.toString().toInt() - 1
                    num_add.text = countiint.toString()
                }


            }


            R.id.add_but -> {
                var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
                var ask = sharedPref.getBoolean("ask",false)

                if (ask)
                {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Comfirmation")
                    builder.setMessage("Are you sure that you want to add?")
                    builder.setPositiveButton("Yes") { _, _ ->



                        val number_to_add = num_add.text.toString().toInt()

                        if (calendarDao.findByDate(current).summ+number_to_add>24)
                        {
                            Toast.makeText(requireContext(), R.string.toast_24, Toast.LENGTH_SHORT).show()
                        }
                        else {

                            when (cat_to_add) {
                                "red" -> calendarDao.updateR(number_to_add, current)
                                "orange" -> calendarDao.updateO(number_to_add, current)
                                "yellow" -> calendarDao.updateY(number_to_add, current)
                                "green" -> calendarDao.updateG(number_to_add, current)
                                "blue" -> calendarDao.updateB(number_to_add, current)
                                "d_blue" -> calendarDao.updateDB(number_to_add, current)
                                "purple" -> calendarDao.updatePP(number_to_add, current)
                                "pink" -> calendarDao.updateP(number_to_add, current)
                                "grey" -> calendarDao.updateGr(number_to_add, current)
                                "black" -> calendarDao.updateBl(number_to_add, current)

                                else -> {
                                    Log.v("MyLog", "Wrong category")
                                }

                            }

                            var new_summ = calendarDao.findByDate(current).summ+number_to_add
                            calendarDao.updateSumm(new_summ, current)
                        }





                        //if(calendarDao.findByDate(current).id==null)
                        //{
                        //    Log.v("MyLog", "None")
                        //}




                        //Log.v("MyLog", "newDate " + newDate)
                        //calendarDao.insertAll(newDate)

                        // find by date add
                        // find by date update

                        // add to base
                        // popup
                        // close
                        Toast.makeText(requireContext(), R.string.toast_added, Toast.LENGTH_SHORT).show()


                    }

                    builder.setNegativeButton("No"){ _, _ ->


                    }


                    builder.show()

                }

            else {

                    val number_to_add = num_add.text.toString().toInt()

                    if (calendarDao.findByDate(current).summ+number_to_add>24)
                    {
                        Toast.makeText(requireContext(), R.string.toast_24, Toast.LENGTH_SHORT).show()
                    }
                    else {

                        when (cat_to_add) {
                            "red" -> calendarDao.updateR(number_to_add, current)
                            "orange" -> calendarDao.updateO(number_to_add, current)
                            "yellow" -> calendarDao.updateY(number_to_add, current)
                            "green" -> calendarDao.updateG(number_to_add, current)
                            "blue" -> calendarDao.updateB(number_to_add, current)
                            "d_blue" -> calendarDao.updateDB(number_to_add, current)
                            "purple" -> calendarDao.updatePP(number_to_add, current)
                            "pink" -> calendarDao.updateP(number_to_add, current)
                            "grey" -> calendarDao.updateGr(number_to_add, current)
                            "black" -> calendarDao.updateBl(number_to_add, current)

                            else -> {
                                Log.v("MyLog", "Wrong category")
                            }

                        }

                        var new_summ = calendarDao.findByDate(current).summ+number_to_add
                        calendarDao.updateSumm(new_summ, current)
                    }





                    //if(calendarDao.findByDate(current).id==null)
                    //{
                    //    Log.v("MyLog", "None")
                    //}




                    //Log.v("MyLog", "newDate " + newDate)
                    //calendarDao.insertAll(newDate)

                    // find by date add
                    // find by date update

                    // add to base
                    // popup
                    // close
                    Toast.makeText(requireContext(), R.string.toast_added, Toast.LENGTH_SHORT).show()

            }
            }




            else -> {  }
        }

        if (popupWindow != null) {
            popupWindow.dismiss()
        }
    }




    companion object {
        /**
         * Use thisfactory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Add.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Add().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}



