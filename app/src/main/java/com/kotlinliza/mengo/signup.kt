package com.kotlinliza.mengo

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

private lateinit var auth: FirebaseAuth
class signup : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        auth=FirebaseAuth.getInstance()

        val button = findViewById<Button>(R.id.bttnsignup)


        val email= findViewById<EditText>(R.id.stemail)
        val password=findViewById<EditText>(R.id.stpassword)
        val confirm = findViewById<EditText>(R.id.cnfpassword)

        button.setOnClickListener{
            //  startActivity(Intent( this, MainActivity::class.java))

            val email= email.text.toString()
            val password =password.text.toString()
            val conf =confirm.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful && conf==password) {
                        startActivity(Intent(this, MainActivity::class.java))
                        Toast.makeText(
                            baseContext,
                            "Authentication successful.",
                            Toast.LENGTH_SHORT,
                        ).show()


                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "weak password or invalid credentials.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }

        }


    }

    fun back(view: View) {
        val intent = Intent(this,login::class.java)
        startActivity(intent)
    }





}