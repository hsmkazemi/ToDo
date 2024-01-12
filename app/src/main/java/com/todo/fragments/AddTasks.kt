package com.todo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.todo.R
import com.todo.databinding.FragmentAddTasksBinding
import com.todo.model.ToDo
import com.todo.utils.Picker
import com.todo.utils.fullDate
import com.todo.utils.hour
import com.todo.utils.minute

class AddTasks : Fragment() {
    private lateinit var binding: FragmentAddTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBTN.setOnClickListener {
            val newToDo = ToDo(
                binding.outlinedTitleField.editText?.text.toString(),
                binding.outlinedDescriptionField.editText?.text.toString(),
                "$hour:$minute",
                fullDate,
                false
            )
            Navigation.findNavController(binding.saveBTN).navigate(R.id.action_addTasks_to_currentToDoS)
            todoList.add(newToDo)
        }

        binding.dateChoose.setOnClickListener {
            Picker(parentFragmentManager, binding.dateChoose)
        }
    }
}