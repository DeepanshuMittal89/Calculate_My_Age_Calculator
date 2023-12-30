package com.example.calculateyourageinminutes


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
//    private var tv_selectedDate: TextView? = null
//    private var tvageToMinuts: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val datebutton:Button = findViewById(R.id.datebutton)
        datebutton.setOnClickListener{
            clickOnDate()
        }
    }
    fun clickOnDate() {

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
            view, year,month,dayOfMonth ->
            Toast.makeText(this, "Selected Year is $year, Selected Month is ${month+1}" +
                    ", Selected day is $dayOfMonth", Toast.LENGTH_SHORT).show()

            val selectedDate = "$dayOfMonth/${month+1}/$year"
            var tv_selectedDate:TextView = findViewById(R.id.tv_selectedDate)
            var tvageToMinuts:TextView = findViewById(R.id.tvageToMinutes)
            tv_selectedDate.text = selectedDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date = sdf.parse(selectedDate)
            val theDate = date.time/60000
            val currentTime = sdf.parse(sdf.format(System.currentTimeMillis()))
            currentTime?.let {
                val currentDate= currentTime.time/60000
                val difference = currentDate - theDate
                tvageToMinuts.text = difference.toString()
            }



        },
            year,
            month,
            day
        ).show()
    }
}