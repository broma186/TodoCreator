package com.example.todocreator.api

import androidx.room.Update
import com.example.todocreator.data.Todo
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

/*
· Create: POST to BASE_URL + /todos.json
· Read: GET to BASE_URL + /todos.json
· Update: PATCH to BASE_URL + /todos/{id}.json
· Get By Id: GET to BASE_URL/todos/{id}.json
· Delete: DELETE with BASE_URL + /todos/{id}.json
 */
interface TodoService {

    @GET("/todos.json")
    suspend fun readTodos(): Response<List<Todo>>

    @POST("/todos.json")
    suspend fun createTodo(): Todo

    @PATCH("/todos/{id}.json")
    suspend fun updateTodo(): Response<Todo>

    @GET("/todos/{id}.json")
    suspend fun getTodo(): Response<Todo>

    @DELETE("/todos/{id}.json")
    suspend fun deleteTodo(): ResponseBody
}


