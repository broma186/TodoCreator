package com.example.todocreator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todocreator.R
import com.example.todocreator.data.Todo
import com.example.todocreator.databinding.ListItemTodoBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todocreator.databinding.ListItemLoadingBinding
import com.example.todocreator.viewmodels.TodoViewModel
import android.view.View
import com.example.todocreator.databinding.ActivityTodoBinding.bind


class TodoListAdapter: ListAdapter<Todo, BaseViewHolder<Todo>>(TodoDiffCallback()) {

    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Todo> {
        when (viewType) {
            VIEW_TYPE_NORMAL -> return TodoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    com.example.todocreator.R.layout.list_item_todo, parent, false
                ))
            VIEW_TYPE_LOADING -> return LoadingViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    com.example.todocreator.R.layout.list_item_loading, parent, false
                ))
        }
        return TodoViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            com.example.todocreator.R.layout.list_item_todo, parent, false
        ))
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<Todo>, position: Int) {
        getItem(position).let { todos ->
            with(holder) {
                bind(todos)
            }
        }
    }

    class TodoViewHolder (
        private val binding: ListItemTodoBinding
    ) : BaseViewHolder<Todo>(binding.root) {
        init { }
        override fun bind(todo: Todo) {
            with(binding) {
                viewModel = TodoViewModel(todo)
                executePendingBindings()
            }
        }
    }

    class LoadingViewHolder(
        private val binding: ListItemLoadingBinding
    ) : BaseViewHolder<Todo>(binding.root) {
        override fun bind(item: Todo) {
            with(binding) {
                executePendingBindings()
            }
        }
    }

    private class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {

        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.name == newItem.name
        }
    }
}