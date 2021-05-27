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

class ApplicationActivity : AppCompatActivity() {
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
    private var etDate: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)
        spinnerCountry = findViewById<AutoCompleteTextView>(R.id.spinnerCountryID)
        spinnerPosition = findViewById(R.id.spinnerPositionID)
        etFirstname = findViewById<View>(R.id.txtFirstName) as EditText
        etLastname = findViewById<View>(R.id.txtLastName) as EditText
        etstreetAddress1 = findViewById<View>(R.id.txtStreetAddress1) as EditText
        etstreetAddress2 = findViewById<View>(R.id.txtStreetAddress2) as EditText
        etCity = findViewById<View>(R.id.txtCity) as EditText
        etState = findViewById<View>(R.id.txtState) as EditText
        etPostal = findViewById<View>(R.id.txtPostal) as EditText
        etAreaCode = findViewById<View>(R.id.txtArea) as EditText
        etEmail = findViewById<View>(R.id.txtEmail) as EditText
        etPhone = findViewById<View>(R.id.txtPhone) as EditText
        etDate = findViewById<View>(R.id.dataPicker) as EditText
        etDate!!.setOnClickListener { showDateDialog(etDate) }
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

//    override fun onCreateOptionsMenu(menus: Menu): Boolean {
//        menuInflater.inflate(R.menu.overflow, menus)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        if (id == R.id.logOut) {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//        return super.onOptionsItemSelected(item)
//    }

    fun send(view: View?) {
        val firstName = etFirstname!!.text.toString()
        val lastName = etLastname!!.text.toString()
        val streetAddress1 = etstreetAddress1!!.text.toString()
        val streetAddress2 = etstreetAddress2!!.text.toString()
        val city = etCity!!.text.toString()
        val state = etState!!.text.toString()
        val postal = etPostal!!.text.toString()
        val country = spinnerCountry.toString()
        val email = etEmail!!.text.toString()
        val areaCode = etAreaCode!!.text.toString()
        val phone = etPhone!!.text.toString()
        val position = spinnerPosition.toString()
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
        Toast.makeText(this, "Application successful", Toast.LENGTH_SHORT).show()
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
            this@ApplicationActivity,
            dateSetListener,
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        ).show()
    }
}