package com.example.lesson1


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView


class MyViewModel(application: Application) : AndroidViewModel(application) {
    var clickCount = 0
    val adapter = MessageListAdapter()
    val currentClickCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }



}