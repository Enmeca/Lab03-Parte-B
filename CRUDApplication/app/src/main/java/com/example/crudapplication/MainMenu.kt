package com.example.crudapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val bundle = intent.extras
        val msg = bundle!!.getString("msg")
        val l =  bundle.getSerializable("Login") as User
    }
}