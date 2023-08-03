package com.kotlinliza.mengo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splasscreen : AppCompatActivity() {
    private val splash = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splasscreen)
        Handler().postDelayed({
            val intent = Intent(this,login::class.java)
            startActivity(intent)
        },splash)
    }
}

private fun Handler.postDelayed(function: () -> Unit) {


}
