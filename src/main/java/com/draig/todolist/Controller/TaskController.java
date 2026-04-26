package com.draig.todolist.Controller;

import com.draig.todolist.Services.ToDoService;
import com.draig.todolist.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final ToDoService toDoService;

    public TaskController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = toDoService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        ToDoService.createTask(title);
        return "redirect:/";
    }
}
