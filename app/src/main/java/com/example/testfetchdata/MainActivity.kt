package com.example.testfetchdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val api = JsonPlaceholderApi.create() //creates a JsonPlaceholderApi object that uses retrofit to handle the get request
        //by calling getPosts() method we are making the request
        //we set the response type to be a list of PostDataModel
        api.getPosts().enqueue(object : Callback<List<PostDataModel>> {
            override fun onResponse(call: Call<List<PostDataModel>>, response: Response<List<PostDataModel>>) {
                //if the response is successful, posts gets the body of the response
                if (response.isSuccessful) {
                    val posts = response.body()
                    //if the body contains data, we append that data to the Post Adapter which binds that data to the recyclerView
                    //methods inside PostAdapter class are being called at creation (onCreateViewHolder)
                    //see PostAdapter.kt
                    if (posts != null) {
                        setupRecyclerView(posts)
                    }
                }
            }

            override fun onFailure(call: Call<List<PostDataModel>>, t: Throwable) {
                // Handle failure here
            }
        })
    }


    //ToDo: here goes the code for clicking on a post item that sends the user to the details page


    //function that updates recyclerView to be able with the functionality of clicking on the posts
    private fun setupRecyclerView(posts: List<PostDataModel>) {
        postAdapter = PostAdapter(posts) { post ->
            openPostDetailsActivity(post)
        }
        recyclerView.adapter = postAdapter
    }

    //function that sends to another activity
    private fun openPostDetailsActivity(post: PostDataModel){
        val intent = Intent(this, PostDetailsActivity::class.java)
        intent.putExtra("POST_TITLE", post.title)
        intent.putExtra("POST_BODY", post.body)
        startActivity(intent)
    }


}