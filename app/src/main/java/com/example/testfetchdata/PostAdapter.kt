package com.example.testfetchdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//receives as argument the posts and extends the RecyclerView Adapter class
class PostAdapter(private val posts: List<PostDataModel>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    //creates a ViewHolder. the ViewHolder represents a single item view in the RecyclerView and holds references to the views within that item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    //binds data to each item view in the RecyclerView
    //onBindViewHolder function is called automatically by the RecyclerView when it needs to populate or update the views for a particular item in the list.
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //for current post
        val post = posts[position]
        //PostViewHolder's bind function gives the data to the texts
        holder.bind(post)
    }

    //gets how many items are in the list
    override fun getItemCount() = posts.size

    //Inside the holder class the data is given to the texts
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //define variables that represent the TextViews from the XML
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)

        //function to bind the data to the actual text in the TextView
        fun bind(post: PostDataModel) {
            titleTextView.text = post.title
            bodyTextView.text = post.body
        }
    }

}



/*
In the PostAdapter, the onBindViewHolder function is called automatically by the RecyclerView when it needs to display or update data for a specific item in the list.

Here's a more detailed explanation of how it works:

When you set up the RecyclerView and provide it with the PostAdapter as its adapter (usually done in the onCreate or onCreateView method of your activity/fragment), the RecyclerView is aware of the adapter and its data.

When the RecyclerView needs to display a new item or update an existing item (e.g., when you scroll the list or when the RecyclerView is initially populated), it calls the onBindViewHolder method of the adapter.

Inside the onBindViewHolder method, you have the responsibility to bind the data from the data list to the views of the item layout (e.g., setting the title and body of a Post object to the respective TextView views).

The onBindViewHolder method receives two parameters: the holder parameter, which represents the PostViewHolder for the current item, and the position parameter, which indicates the position of the item in the data list that needs to be displayed.

The adapter takes care of recycling views (reusing the views that are no longer visible) and automatically calls onBindViewHolder whenever a new item comes into view or when an existing item's data needs to be updated.

To summarize, the onBindViewHolder function is called automatically by the RecyclerView when it needs to populate or update the views for a particular item in the list. As you scroll through the list or when the list is first displayed, this method is repeatedly called to show the appropriate data for each item in the RecyclerView.

 */