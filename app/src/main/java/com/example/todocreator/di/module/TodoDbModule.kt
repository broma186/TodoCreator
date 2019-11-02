package com.example.todocreator.di.module

import android.content.Context
import androidx.room.Room
import com.example.gitrepositoryhub.data.TodoDatabase
import com.example.todocreator.data.TodoDao
import com.example.todocreator.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TodoDbModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideTodoDatabase(context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java, DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase): TodoDao {
        return todoDatabase.todoDao()
    }
}