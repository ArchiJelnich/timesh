package com.example.myapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_categ.*
import kotlinx.android.synthetic.main.fragment_grath.*
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Calendar
import java.text.SimpleDateFormat
import javax.xml.datatype.DatatypeConstants.MONTHS
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Grath.newInstance] factory method to
 * create an instance of this fragment.
 */
class Grath : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var current = "2020-01-01"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(activity);
        current = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
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
        return inflater.inflate(R.layout.fragment_grath, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val contexth = activity

        date_stop.text = current
        var new_data_date = LocalDate.parse(current, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        date_start.text = new_data_date.minusDays(9).toString()
        //Log.v("MyLog", "Date setted")


        val cubes = ArrayList<TextView>(240)



        var lay = l_1

            for (i in 0 until 10) {

                when (i) {
                    0 -> lay = l_1
                    1 -> lay = l_2
                    2 -> lay = l_3
                    3 -> lay = l_4
                    4 -> lay = l_5
                    5 -> lay = l_6
                    6 -> lay = l_7
                    7 -> lay = l_8
                    8 -> lay = l_9
                    9 -> lay = l_10
                    else -> {

                    }
                }



                for (j in 0 until 24) {

                    var k = i*24 + j

                    cubes.add(TextView(contexth))

                    //cubes[k] = TextView(contexth)

                    cubes[k].layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    cubes[k].gravity = Gravity.CENTER
                    cubes[k].width=60
                    cubes[k].height=60

                    cubes[k].setBackgroundColor(Color.parseColor("#000000"))

                    lay.addView(cubes[k])
                }
            }





        date_stop.setOnClickListener { onClick(date_stop, cubes) }
        date_start.setOnClickListener { onClick(date_start, cubes) }



        DrawGrath(cubes);






    }

    @SuppressLint("ResourceAsColor")
    fun DrawGrath(cubes :ArrayList<TextView>) {
        val dates = ArrayList<LocalDate>(10)

        val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "calendar").allowMainThreadQueries().build() //MUST BE REFACTOR TO THREAD!!!
        val calendarDao = db.calendarDao()
        var k=0

        for (i in 0 until 10)
        {

            dates.add(LocalDate.parse(date_start.text, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
            dates[i]= dates[i].plusDays(i.toLong())
            Log.v("MyLog", "Check date " + i + " " + dates[i])
            //Log.v("MyLog", "Check date_f " + dates[i].format(DateTimeFormatter.ofPattern("yyyyMMdd")))
            //val formattedDate = dates[i].format(DateTimeFormatter.ofPattern("yyyyMMdd"))
            //dates[i] = LocalDate.parse(formattedDate,DateTimeFormatter.ofPattern("yyyyMMdd"))


            calendarDao.findByDate(dates[i].format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString())?. let {

                Log.v("MyLog", "We have records " + dates[i].format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString() + " summ=" + calendarDao.findByDate(dates[i].format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString()).summ)
                var current_obj = calendarDao.findByDate(dates[i].format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString())

                for (i in 0 until current_obj.red)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.red))
                    cubes[k].visibility = View.VISIBLE
                    k++
                    //Log.v("MyLog", "check red " + k)
                }
                for (i in 0 until current_obj.orange)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.orange))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.yellow)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.yellow))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.green)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.green))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.blue)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.blue))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.d_blue)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.d_blue))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.purple)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.purple))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.pink)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.pink))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.grey)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.grey))
                    cubes[k].visibility = View.VISIBLE
                    k++
                }
                for (i in 0 until current_obj.black)
                {
                    cubes[k].setBackgroundColor(resources.getColor(R.color.black))
                    cubes[k].visibility = View.VISIBLE
                    k++


                }

                for (i in 0 until (24-current_obj.summ))
                {
                    cubes[k].visibility = View.INVISIBLE
                    k++
                    //Log.v("MyLog", "set gone " + i)


                }

            } ?: let {
                for (i in 1.. 24)
                {
                    cubes[k].visibility = View.INVISIBLE
                    //cubes[k].setBackgroundColor(Color.GRAY)
                    //Log.v("MyLog", "set gone ")
                    k++
                }
            }

        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("ResourceAsColor")
    fun onClick(v: View, cubes :ArrayList<TextView>) {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        when (v.id) {
            R.id.date_stop -> {

                val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    //date_stop.setText("" + dayOfMonth + "." + monthOfYear + "." + year)
                    ///ISO_LOCAL_DATE
                    var new_data_text = "" + dayOfMonth + "." + (monthOfYear+1) + "." + year
                    var new_data_date = LocalDate.parse(new_data_text, DateTimeFormatter.ofPattern("d.M.yyyy"))
                    date_stop.text = new_data_date.toString()
                    new_data_date = new_data_date.minusDays(9)
                    date_start.text = new_data_date.toString()
                    DrawGrath(cubes)
                }, year, month, day)


                dpd.show()

            }
            R.id.date_start -> {


                val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var new_data_text = "" + dayOfMonth + "." + (monthOfYear+1) + "." + year
                    var new_data_date = LocalDate.parse(new_data_text, DateTimeFormatter.ofPattern("d.M.yyyy"))
                    date_start.text = new_data_date.toString()
                    new_data_date = new_data_date.plusDays(9)
                    date_stop.text = new_data_date.toString()
                    DrawGrath(cubes)
                }, year, month, day)
                dpd.show()

            }

            else ->
            {
                Log.v("MyLog", "Error")

            }
        }}


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Grath.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Grath().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

