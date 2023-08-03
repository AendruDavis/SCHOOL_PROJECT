package com.kotlinliza.mengo

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
class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth= FirebaseAuth.getInstance()

        val button = findViewById<Button>(R.id.btnlogin)


        val email1= findViewById<EditText>(R.id.etemail)
        val password1=findViewById<EditText>(R.id.etpassword)

        button.setOnClickListener{
            //  startActivity(Intent( this, MainActivity::class.java))

            val email= email1.text.toString()
            val password =password1.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
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
                            "invalid credentials.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }

        }











    }

    fun skip(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun register(view: View) {
        val intent = Intent(this,signup::class.java)
        startActivity(intent)
    }


}