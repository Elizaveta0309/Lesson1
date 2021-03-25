package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        val user = intent.getParcelableExtra<User>("user")
        val message = intent.getStringExtra("message")
        messageTextView.text= message
        userTextView.text ="Email: "+user.email +"\n"+ "Пароль: "+user.password +"\n"
    }
}