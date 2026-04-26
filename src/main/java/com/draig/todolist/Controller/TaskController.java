package com.draig.todolist.Controller;

import com.draig.todolist.Services.ToDoService;
import com.draig.todolist.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final ToDoService toDoService;

    public TaskController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String getTasks(Model model) {
        List<Task> tasks = toDoService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/")
    public String createTask(@RequestParam String title) {
        toDoService.createTask(title);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        toDoService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        toDoService.toggleTask(id);
        return "redirect:/";
    }
}