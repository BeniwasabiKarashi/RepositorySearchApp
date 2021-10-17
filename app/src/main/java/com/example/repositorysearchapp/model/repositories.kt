package com.example.repositorysearchapp.model

data class Repositories (
    val accept: String,
    val q: String,
    val sort: String,
    val order: String,
    val perPage: Int,
    val page: Int
)