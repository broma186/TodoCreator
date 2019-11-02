package com.example.gitrepositoryhub.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todocreator.utils.DATABASE_NAME
import com.example.todocreator.data.Todo
import com.example.todocreator.data.TodoDao

/*
Not needed yet but can be implemented so that each repository is stored in the
database.

@Database(entities = [FavoriteShow::class], version = 2, exportSchema = false)
abstract class TvMazeDatabase : RoomDatabase() {

    abstract fun showDao(): ShowDao

    companion object {
        const val DATABASE_NAME = "tvmaze.db"
    }
}

 */
@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}