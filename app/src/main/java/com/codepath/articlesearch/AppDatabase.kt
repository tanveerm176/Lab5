package com.codepath.articlesearch

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//note:The following code defines an AppDatabase class to hold the database.
// AppDatabase defines the database configuration and serves as the app's
// main access point to the persisted data. The database class must satisfy the following conditions:

@Database(entities = [ArticleEntity::class], version = 1)
//note:The class must be annotated with a @Database annotation
// that includes an entities array that lists all of the
// data entities associated with the database. In our case, just the ArticleEntity type.

//note (...,version=1)
// This is also where we can version the database,
// which is very important in 🌐 production apps.
// If you ever change the amounts or types of data you're
// saving in your tables, you will have to write migrations to newer versions of the database.

abstract class AppDatabase: RoomDatabase() {
    //note:The class must be an abstract class that extends RoomDatabase.

    abstract fun articleDao(): ArticleDao
    //note:For each DAO class that is associated with the database,
    // the database class must define an abstract method that has
    // zero arguments and returns an instance of the DAO class.


    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "Articles-db"
            ).build()
    }
}