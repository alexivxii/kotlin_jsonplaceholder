package com.example.testfetchdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)

        //setting the toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //getting the arguments sent to this page and binding them to the textViews

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val bodyTextView = findViewById<TextView>(R.id.bodyTextView)

        // Retrieve the extras using the correct data type (String)
        val postTitle = intent.getStringExtra("POST_TITLE")
        val postBody = intent.getStringExtra("POST_BODY")
        val postId = intent.getIntExtra("POST_ID",-1)

        titleTextView.text = postTitle
        bodyTextView.text = postBody

        fetchCommentsForPost(postId)
    }

    private fun fetchCommentsForPost(postId: Int){

        val api = JsonPlaceholderApi.create()

        api.getComments(postId).enqueue(object : Callback<List<CommentDataModel>> {
            override fun onResponse(call: Call<List<CommentDataModel>>, response: Response<List<CommentDataModel>>) {
                if (response.isSuccessful) {
                    val comments = response.body() ?: emptyList()
                    displayComments(comments)
                } else {
                    // Handle error response
                }
            }

            override fun onFailure(call: Call<List<CommentDataModel>>, t: Throwable) {
                // Handle network or API call failure
            }
        })

    }

    private fun displayComments(comments: List<CommentDataModel>) {
        val recyclerView = findViewById<RecyclerView>(R.id.commentsRecyclerView)
        val commentAdapter = CommentAdapter(comments)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = commentAdapter
    }


    //handle the back button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                // Handle the Up button press by navigating up to the parent activity (MainActivity)
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}

