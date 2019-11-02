package com.example.todocreator.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todocreator.data.Todo

class TodoViewModel(todo: Todo) : ViewModel() {

    private val todo = checkNotNull(todo)

    val id
        get() = todo.id

    val name
        get() = todo.name

    val status
        get() = todo.status

    val expiryDate
        get() = todo.expiryDate

    val description
        get() = todo.description

}