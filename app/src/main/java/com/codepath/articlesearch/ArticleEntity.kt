package com.codepath.articlesearch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//note: Data entities represent tables in your app's database.
// Each instance of an Entity data class represents a row in a table for articles in the app's database.
// Essentially, we're creating a "template" for each row in our future database table,
// by specifying the columns. (This is somewhat similar to the models we used when serializing JSON!)

@Entity(tableName = "article_table")
//note: create an entity with the name of the table

data class ArticleEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    //note:Entries in databases need a unique primary key to be distinguished from each other.
    // In our case, we can just autogenerate a random unique Long.

    @ColumnInfo(name = "headline") val headline: String?,
    //note: String? = nullable String type
    @ColumnInfo(name = "articleAbstract") val articleAbstract : String?,
    @ColumnInfo(name = "byline") val byline: String?,
    @ColumnInfo(name = "mediaImageUrl") val mediaImageUrl: String?

        )