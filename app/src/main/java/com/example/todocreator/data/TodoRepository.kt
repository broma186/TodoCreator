package com.example.todocreator.data

import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(
    val todoDao: TodoDao
) {

    fun writeTodos(todos : List<Todo>?) = runBlocking {todoDao.insertAll(todos)}

    fun getTodos() = todoDao.getTodos()

}