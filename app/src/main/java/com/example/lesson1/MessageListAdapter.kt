package com.example.lesson1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.answer_message.view.*
import kotlinx.android.synthetic.main.my_message.view.*

class MessageListAdapter:RecyclerView.Adapter<MessageListAdapter.ViewHolder>(){
     var messagesList = mutableListOf<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == 0){
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.my_message,parent,false))
        } else{
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.answer_message,parent,false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMessage = messagesList[position]
        if(position % 2 ==0){
        holder.itemView.myMessageTextView.text = currentMessage.mText
        } else{
            holder.itemView.answerMessageTextView.text = currentMessage.mText
        }
    }

    override fun getItemCount(): Int {
       return messagesList.size
    }
    fun insertMessage (message:Message){
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return (position%2)
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}