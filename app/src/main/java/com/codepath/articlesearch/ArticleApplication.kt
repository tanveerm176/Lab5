package com.codepath.articlesearch

import android.app.Application

//note:To interact with our database we will need to get an instance of it!
// The Application class in Android is the base class within an
// Android app that contains all other components such as activities and services.

class ArticleApplication: Application() {
    val db by lazy { AppDatabase.getInstance(this) }
    //note: A lazy initialization here just means we don't create this variable until it needs to be used.
}