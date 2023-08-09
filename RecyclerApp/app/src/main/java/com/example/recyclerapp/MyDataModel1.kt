package com.example.recyclerapp

class MyDataModel1(title: String?, genre: String?, year: String?)
{
    private var title: String
    private var genre: String
    private var year: String
    init {
        this.title = title!!
        this.genre = genre!!
        this.year = year!!
    }
    fun getTitle(): String? {
        return title
    }
    fun getYear(): String? {
        return year
    }
    fun getGenre(): String? {
        return genre
    }
}