package com.example.todocreator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.todocreator.databinding.ActivityTodoBinding
import com.example.todocreator.viewmodels.TodoViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TodoActivity : AppCompatActivity(), HasAndroidInjector, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    val context: Context = this
    lateinit var binding: ActivityTodoBinding

    private lateinit var todoViewModel : TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityTodoBinding>(this, R.layout.activity_todo)
        setSupportActionBar(binding.toolbar)

        binding.todoSwipeRefresh

        // Initialize the to do view model using injected viewModelFactory.
        todoViewModel = ViewModelProviders.of(this, viewModelFactory)[TodoViewModel::class.java]


    }

    fun setupTodoList() {
       // binding.todoList.layoutManager = LinearLayoutManager(this)
        //adapter = RepositoriesAdapter()
       // binding.todoList.adapter = adapter
    }

    override fun onRefresh() {

    }
}
