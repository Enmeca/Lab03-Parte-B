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
        var dato: JobApplication? = null
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
            etCountry = findViewById<View>(R.id.txtCountryView) as EditText
            etCountry!!.setText(dato!!.country)
            etDate = findViewById<View>(R.id.txtDateView) as EditText
            etDate!!.setText(dato!!.date)
            etPosition = findViewById<View>(R.id.txtAplyView) as EditText
            etPosition!!.setText(dato!!.position)
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
        }
    }