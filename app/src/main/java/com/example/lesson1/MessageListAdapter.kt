package com.example.lesson1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.answer_message.view.*
import kotlinx.android.synthetic.main.my_message.view.*

class MessageListAdapter : RecyclerView.Adapter<MessageListAdapter.ViewHolder>() {
    var messagesList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == 0) {
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.my_message, parent, false)
            )
        } else {
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.answer_message, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMessage = messagesList[position]
        if (position % 2 == 0) {
            holder.onMyMessageBind(currentMessage)
        } else {
            holder.onAnswerMessageBind(currentMessage)
        }
    }

    override fun getItemCount() = messagesList.size

    fun insertMessage(message: String) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = position % 2


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onMyMessageBind(mess: String) {
            itemView.myMessageTextView.text = mess
        }

        fun onAnswerMessageBind(mess: String) {
            itemView.answerMessageTextView.text = mess
        }
    }
}