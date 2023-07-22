package com.example.testfetchdata

//class model with all the variable from the posts route
data class PostDataModel (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)