package com.example.testfetchdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils


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

        titleTextView.text = postTitle
        bodyTextView.text = postBody
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

