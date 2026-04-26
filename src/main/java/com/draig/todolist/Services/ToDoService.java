package com.draig.todolist.Services;

import com.draig.todolist.model.Task;
import com.draig.todolist.model.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final TaskRepository taskRepository;

    public ToDoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
