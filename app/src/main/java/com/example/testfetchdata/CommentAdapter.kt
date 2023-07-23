package com.example.testfetchdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private val comments: List<CommentDataModel>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentAdapter.CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //define variables that represent the TextViews from the XML
        private val commentNameTextView: TextView = itemView.findViewById(R.id.commentNameTextView)
        private val commentEmailTextView: TextView = itemView.findViewById(R.id.commentEmailTextView)
        private val commentBodyTextView: TextView = itemView.findViewById(R.id.commentBodyTextView)

        //function to bind the data to the actual text in the TextView
        fun bind(coment: CommentDataModel) {
            commentNameTextView.text = coment.name
            commentEmailTextView.text = coment.email
            commentBodyTextView.text = coment.body
        }
    }

}