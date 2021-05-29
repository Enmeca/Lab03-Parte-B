package com.example.crudapplication
import androidx.appcompat.app.AppCompatActivity
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.os.Bundle

import android.widget.ArrayAdapter
import android.content.Intent
import com.example.crudapplication.JobApplication
import android.widget.Toast
import android.app.DatePickerDialog.OnDateSetListener
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.view.Menu
import android.view.MenuItem
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class EditAplication: AppCompatActivity() {

    var jobs: JobApplications = JobApplications.instance

        var dato: JobApplication? = null
        private var pos:Int = -1
        private lateinit var spinnerCountry: AutoCompleteTextView
        private lateinit var spinnerPosition: AutoCompleteTextView

        private var etFirstname: EditText? = null
        private var etLastname: EditText? = null
        private var etstreetAddress1: EditText? = null
        private var etstreetAddress2: EditText? = null
        private var etCity: EditText? = null
        private var etState: EditText? = null
        private var etPostal: EditText? = null
        private var etAreaCode: EditText? = null
        private var etEmail: EditText? = null
        private var etPhone: EditText? = null
        private var etCountry: EditText? = null
        private var etDate: EditText? = null
        private var etPosition: EditText? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_view_application)
            dato = intent.getSerializableExtra("dato") as JobApplication?

//            etCountry = findViewById<View>(R.id.txtCountryView) as EditText
//            etCountry!!.setText(dato!!.country)


            spinnerPosition = findViewById<AutoCompleteTextView>(R.id.Position)
            spinnerPosition!!.setText(dato!!.position)


            spinnerCountry = findViewById<AutoCompleteTextView>(R.id.CountryID)
            spinnerCountry!!.setText(dato!!.country)


            etDate = findViewById<View>(R.id.txtDateView) as EditText
            etDate!!.setText(dato!!.date)
            etDate!!.setOnClickListener { showDateDialog(etDate) }

            etFirstname = findViewById<View>(R.id.txtFirstNameView) as EditText
            etFirstname!!.setText(dato!!.firstName)
            etLastname = findViewById<View>(R.id.txtLastNameView) as EditText
            etLastname!!.setText(dato!!.lastName)
            etstreetAddress1 = findViewById<View>(R.id.txtStreetAddress1View) as EditText
            etstreetAddress1!!.setText(dato!!.streetAddress1)
            etstreetAddress2 = findViewById<View>(R.id.txtStreetAddress2View) as EditText
            etstreetAddress2!!.setText(dato!!.streetAddress2)
            etCity = findViewById<View>(R.id.txtCityView) as EditText
            etCity!!.setText(dato!!.city)
            etState = findViewById<View>(R.id.txtStateView) as EditText
            etState!!.setText(dato!!.state)
            etPostal = findViewById<View>(R.id.txtPostalView) as EditText
            etPostal!!.setText(dato!!.postal)
            etAreaCode = findViewById<View>(R.id.txtAreaView) as EditText
            etAreaCode!!.setText(dato!!.areaCode)
            etEmail = findViewById<View>(R.id.txtEmailView) as EditText
            etEmail!!.setText(dato!!.email)
            etPhone = findViewById<View>(R.id.txtPhoneView) as EditText
            etPhone!!.setText(dato!!.phone)

            pos= intent.getSerializableExtra("position") as Int



            val countries = arrayOf(
                "Canada",
                "Costa Rica",
                "El Salvador",
                "Guatemala",
                "Honduras",
                "Mexico",
                "Nicaragua",
                "Panama",
                "United States"
            )
            val positions = arrayOf("System Ingeneer", "Secretary", "Administrador", "Security")

           var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
            spinnerCountry.setAdapter(adapter)
            adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, positions)
            spinnerPosition.setAdapter(adapter)
        }
/*FIXME
    -poner las varas en spinner
        -agregarle el autocomplete
*/
    fun send(view: View?) {
        val firstName = etFirstname!!.text.toString()
        val lastName = etLastname!!.text.toString()
        val streetAddress1 = etstreetAddress1!!.text.toString()
        val streetAddress2 = etstreetAddress2!!.text.toString()
        val city = etCity!!.text.toString()
        val state = etState!!.text.toString()
        val postal = etPostal!!.text.toString()
        val country = spinnerCountry!!.text.toString()
        val email = etEmail!!.text.toString()
        val areaCode = etAreaCode!!.text.toString()
        val phone = etPhone!!.text.toString()
        val position = spinnerPosition!!.text.toString()
        val date = etDate!!.text.toString()
        val job = JobApplication(
            firstName,
            lastName,
            streetAddress1,
            streetAddress2,
            city,
            state,
            postal,
            country,
            email,
            areaCode,
            phone,
            position,
            date
        )
        //TODO PROBAR QUE SI EDITE
        jobs.editJob(pos,job)
        Toast.makeText(this, "Enviado Exitosamente", Toast.LENGTH_SHORT).show()
    }


    // --------------------------DatePicker---------------------
    private fun showDateDialog(date_in: EditText?) {
        val calendar = Calendar.getInstance()
        val dateSetListener = OnDateSetListener { view, year, month, dayOfMonth ->
            calendar[Calendar.YEAR] = year
            calendar[Calendar.MONTH] = month
            calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            date_in!!.setText(simpleDateFormat.format(calendar.time))
        }
        DatePickerDialog(
            this@EditAplication,
            dateSetListener,
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        ).show()
    }
    }