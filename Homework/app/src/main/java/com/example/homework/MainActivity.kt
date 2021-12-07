package com.example.homework

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult


class MainActivity : AppCompatActivity() {

    var name1=""
    var num1=""
    var c1=name1+","+num1

    var name2=""
    var num2=""
    var c2=name2+","+num2


    var name3=""
    var num3=""
    var c3=name3+","+num3



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val intent = Intent(Intent.ACTION_DIAL)
        listenNumbers(intent)

    }

    fun listenNumbers(intent: Intent) {
        val textBox=findViewById(R.id.textView) as TextView

        val buttonDel = findViewById(R.id.buttonDel) as Button

        buttonDel.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "Apaguei")
            if(textBox.text.length>=2) textBox.text=textBox.text.toString().subSequence(0,textBox.text.length-1);
            else if(textBox.text.length==1) textBox.text=""
            else null
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button0 = findViewById(R.id.button0) as Button
        // set on-click listener
        button0.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "0")
            textBox.text=textBox.text.toString()+"0";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        button0.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                textBox.text=textBox.text.toString()+"+"
                return true  }
        })

        val button1 = findViewById(R.id.button1) as Button
        // set on-click listener
        button1.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "1")
            textBox.text=textBox.text.toString()+"1";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        button1.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                openSpeedDial(this@MainActivity,1)
                return true  }
        })

        val button2 = findViewById(R.id.button2) as Button
        // set on-click listener
        button2.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "2")
            textBox.text=textBox.text.toString()+"2";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        button2.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                openSpeedDial(this@MainActivity,2)
                return true  }
        })

        val button3 = findViewById(R.id.button3) as Button
        // set on-click listener
        button3.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "3")
            textBox.text=textBox.text.toString()+"3";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }


        button3.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                openSpeedDial(this@MainActivity,3)
                return true  }
        })

        val button4 = findViewById(R.id.button4) as Button
        // set on-click listener
        button4.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "4")
            textBox.text=textBox.text.toString()+"4";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button5 = findViewById(R.id.button5) as Button
        // set on-click listener
        button5.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "5")
            textBox.text=textBox.text.toString()+"5";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button6 = findViewById(R.id.button6) as Button
        // set on-click listener
        button6.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "6")
            textBox.text=textBox.text.toString()+"6";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button7 = findViewById(R.id.button7) as Button
        // set on-click listener
        button7.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "7")
            textBox.text=textBox.text.toString()+"7";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button8 = findViewById(R.id.button8) as Button
        // set on-click listener
        button8.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "8")
            textBox.text=textBox.text.toString()+"8";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button9 = findViewById(R.id.button9) as Button
        // set on-click listener
        button9.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "9")
            textBox.text=textBox.text.toString()+"9";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val buttonAst = findViewById(R.id.buttonAst) as Button
        // set on-click listener
        buttonAst.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "*")
            textBox.text=textBox.text.toString()+"*";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val buttonCard = findViewById(R.id.buttonCard) as Button
        // set on-click listener
        buttonCard.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "#")
            textBox.text=textBox.text.toString()+"#";
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val buttonDial = findViewById(R.id.buttonDial) as Button
        // set on-click listener
        buttonDial.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "DIALING")
            intent.data = Uri.parse("tel:"+textBox.text)
            startActivity(intent)
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val buttonSD = findViewById(R.id.sd1) as Button
        // set on-click listener
        buttonSD.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "DIALING")
            var sharedPref = this?.getSharedPreferences(getString(R.string.file), MODE_PRIVATE)

            val contacto = sharedPref.getString(getString(R.string.c1), ",")
            if (contacto != null) {
                var param= contacto!!.split(",")
                if(param[0]!= null && param[1]!=null) {
                    textBox.text=param[1];
                }
            }
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val buttonSD2 = findViewById(R.id.sd2) as Button
        // set on-click listener
        buttonSD2.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "DIALING")
            var sharedPref = this?.getSharedPreferences(getString(R.string.file), MODE_PRIVATE)

            val contacto = sharedPref.getString(getString(R.string.c2), ",")
            if (contacto != null) {
                var param= contacto!!.split(",")
                if(param[0]!= null && param[1]!=null) {
                    textBox.text=param[1];
                }
            }
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val buttonSD3 = findViewById(R.id.sd3) as Button
        // set on-click listener
        buttonSD3.setOnClickListener {
            Log.println(Log.DEBUG, "DEBUG", "DIALING")
            var sharedPref = this?.getSharedPreferences(getString(R.string.file), MODE_PRIVATE)

            val contacto = sharedPref.getString(getString(R.string.c3), ",")
            if (contacto != null) {
                var param= contacto!!.split(",")
                if(param[0]!= null && param[1]!=null) {
                    textBox.text=param[1];
                }
            }
            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }


    }

    private fun openSpeedDial(context: Context, numero: Int) {

//        var resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                // There are no request codes
//                val data: Intent? = result.data
//                Log.println(Log.DEBUG, "DEBUG", result.data.toString())
////                name1=data.toString()
//            }
//        }

//        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
//        with (sharedPref.edit()) {
//            if(numero==1){
//                putString(getString(R.string.c1), c1)
//                apply()
//            }
//            else if(numero==2){
//                putString(getString(R.string.c2), c2)
//                apply()
//            }
//            else{
//                putString(getString(R.string.c3), c3)
//                apply()
//            }
//        }

        if(numero==1) {
            val intent2 = Intent(context, speedDial::class.java)
            startActivity(intent2)
            Log.println(Log.DEBUG, "DEBUG", "A ENTRAR NO 1")
        }
        else if (numero==2){
            val intent2 = Intent(context, speedDial2::class.java)
            startActivity(intent2)
        }
        else{
            val intent2 = Intent(context, speedDial3::class.java)
            startActivity(intent2)
        }
//        listenNumbers(intent2)


//        resultLauncher.launch(Intent(this@MainActivity, speedDial))

//        intent2.putExtra()

    }
}