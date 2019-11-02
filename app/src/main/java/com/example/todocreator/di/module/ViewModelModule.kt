package com.example.todocreator.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitrepositoryhub.di.ViewModelKey
import com.example.gitrepositoryhub.viewmodels.TodoViewModelFactory
import com.example.todocreator.viewmodels.TodoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindTodoViewModel(todoViewModel: TodoViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(todoViewModelFactory: TodoViewModelFactory): ViewModelProvider.Factory
}
