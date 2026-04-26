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

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}