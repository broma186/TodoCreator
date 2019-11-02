package com.example.todocreator.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitrepositoryhub.di.ViewModelKey
import com.example.gitrepositoryhub.viewmodels.TodoViewModelFactory
import com.example.todocreator.viewmodels.TodoListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TodoListViewModel::class)
    abstract fun bindTodoViewModel(todoListViewModel: TodoListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(todoViewModelFactory: TodoViewModelFactory): ViewModelProvider.Factory
}
