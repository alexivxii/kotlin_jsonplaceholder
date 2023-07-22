package com.example.testfetchdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PostDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val bodyTextView = findViewById<TextView>(R.id.bodyTextView)

        // Retrieve the extras using the correct data type (String)
        val postTitle = intent.getStringExtra("POST_TITLE")
        val postBody = intent.getStringExtra("POST_BODY")

        titleTextView.text = postTitle
        bodyTextView.text = postBody
    }
}

