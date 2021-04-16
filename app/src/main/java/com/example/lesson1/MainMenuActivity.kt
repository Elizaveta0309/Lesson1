 package com.example.lesson1


import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_menu.*

 class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        showGreeting(intent.getParcelableExtra<User>("user"),intent.getStringExtra("message"))
        var clicksCount = 0
        val list = messagesRecycleView
        var adapter = MessageListAdapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val handler = Handler()
        var answersList = arrayOf(
            getString(R.string.firstAnswer),
            getString(R.string.secondAnswer),
            getString(R.string.thirdAnswer)
        )
        sendMessageImageView.setOnClickListener {
            var mess = Message(imputMessageEditText.text.toString())
            adapter.insertMessage(mess)
            mess = Message(answersList[clicksCount])
            val r = Runnable {
                adapter.insertMessage(mess) }
            handler.postDelayed(r,1000)
            clicksCount++
        }

    }
      private fun showGreeting (user:User,message:String){
          greetingTextView.text= message
          nameTextView.text =user.name + " " + user.secondName
      }



}