package com.example.lesson1


import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_menu.*
lateinit var viewModel:MyViewModel

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        showGreeting(intent.getParcelableExtra<User>("user"), intent.getStringExtra("message"))
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        val list = messagesRecycleView
        list.adapter = viewModel.adapter
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val handler = Handler()
        var answersList = resources.getStringArray(R.array.answers)
        sendMessageImageView.setOnClickListener {
            var mess = imputMessageEditText.text.toString()
            viewModel.adapter.insertMessage(mess)
            viewModel.currentClickCount.observe(this, Observer {
                mess = answersList[it]
            })
            val r = Runnable {
                viewModel.adapter.insertMessage(mess)
            }
            handler.postDelayed(r, 1000)
            viewModel.currentClickCount.value = viewModel.clickCount++
        }

    }


    private fun showGreeting(user: User, message: String) {
        greetingTextView.text = message
        nameTextView.text = user.name + " " + user.secondName
    }


}