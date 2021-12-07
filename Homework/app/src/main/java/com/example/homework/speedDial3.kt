package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.app.Activity
import android.content.Context

import android.content.Intent
import android.util.Log
import android.widget.Button


class speedDial3 : AppCompatActivity() {

    var name =""
    var number =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speed_dial)

        var sharedPref = this?.getSharedPreferences(getString(R.string.file), MODE_PRIVATE)
        val contacto = sharedPref.getString(getString(R.string.c3), ",")
        Log.println(Log.DEBUG, "DEBUG", contacto+" aqui")



        var name=""
        var number=""
        if (contacto != null) {
            if(contacto.length>0){
                name=contacto.split(",")[0]
                number=contacto.split(",")[1]
            }
        }

        val nameInput= findViewById<EditText>(R.id.nameInput)
        val numberInput= findViewById<EditText>(R.id.editTextPhone)

        nameInput.text.replace(0, nameInput.text.length, name)
        numberInput.text.replace(0, numberInput.text.length, number)


        nameInput.setOnClickListener {

            // Getting the user input
            val text = nameInput.text
            name = nameInput.text.toString()


            // Showing the user input
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


        }

        numberInput.setOnClickListener {

            // Getting the user input
            val text2 = numberInput.text
            number=numberInput.text.toString()

            // Showing the user input
            Toast.makeText(this, text2, Toast.LENGTH_SHORT).show()


        }

        val buttonSave = findViewById(R.id.buttonSave) as Button
        // set on-click listener
        buttonSave.setOnClickListener {
            if(nameInput.text!= null && numberInput.text!=null){
                Log.println(Log.DEBUG, "DEBUG", "SAVING")
//            sharedPref = this?.getSharedPreferences(getString(R.string.file), Context.MODE_PRIVATE) ?: return@setOnClickListener
            with (sharedPref.edit()) {
                putString(
                    getString(R.string.c3),
                    nameInput.text.toString() + "," + numberInput.text.toString()
                )
                Log.println(
                    Log.DEBUG,
                    "DEBUG",
                    nameInput.text.toString() + "," + numberInput.text.toString()
                )

                apply()
            }
            }
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }




//        finish()

    }


    fun getData(): String {
        return name
    }
}