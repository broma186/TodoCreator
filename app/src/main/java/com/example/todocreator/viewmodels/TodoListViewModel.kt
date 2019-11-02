package com.example.todocreator.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todocreator.api.TodoService
import com.example.todocreator.data.Todo
import com.example.todocreator.data.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class TodoListViewModel @Inject constructor(val todoRepository: TodoRepository,
                                            val todoService: TodoService) : ViewModel() {

    val todoLiveData = MutableLiveData<List<Todo>>()

    init {
        storeTodos()
    }

    fun storeTodos() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<List<Todo>> = todoService.readTodos()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    todoRepository.writeTodos(response.body())
                    todoLiveData.value = response.body()
                } else {
                    throw IOException("Failed to download repositories")
                }
            }
        }
    }
}