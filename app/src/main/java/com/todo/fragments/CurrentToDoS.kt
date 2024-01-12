package com.todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.todo.R
import com.todo.adapter.ToDoAdapter
import com.todo.databinding.FragmentAddTasksBinding
import com.todo.databinding.FragmentCurrentToDoSBinding
import com.todo.model.ToDo

val todoList = mutableListOf<ToDo>()

class CurrentToDoS : Fragment() {
    private lateinit var binding: FragmentCurrentToDoSBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrentToDoSBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addTaskBTN = binding.addTaskBTN
        addTaskBTN.setOnClickListener {
            Navigation.findNavController(addTaskBTN).navigate(R.id.action_currentToDoS_to_addTasks)
        }
        initRecView()
    }

    override fun onResume() {
        super.onResume()
        initRecView()
    }

    private fun initRecView() {
        val adapter = ToDoAdapter(todoList, requireContext())
        binding.recView.adapter = adapter
        binding.recView.layoutManager = LinearLayoutManager(requireContext())
    }
}

//        val textView = view.findViewById<TextView>(R.id.textView1)
//        textView.setOnClickListener {
//            Navigation.findNavController(textView).navigate(R.id.action_currentToDoS_to_addTasks)
//        }
