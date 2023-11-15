package com.example.taskmanager.controller;

import com.example.taskmanager.model.Priority;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.PriorityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.stream.IIOByteBuffer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PriorityRepository priorityRepository;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Task> tasks = taskRepository.findAll();
        List<Priority> priorities = priorityRepository.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("priorities", priorities);
        return "index";
    }
    @PostMapping("/addTask")
    public String addTask(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Long priorityId,
            @RequestParam LocalDateTime dueDate,
            Model model) {
        Optional<Priority> optionalPriority = priorityRepository.findById(priorityId);
        if (optionalPriority.isPresent()) {
            Priority priority = optionalPriority.get();
            Task task = new Task(name, description, priority, dueDate);
            taskRepository.save(task);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Priority not found");
            return "error";
        }

    }
    @RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable  UUID taskId, Model model) {
        taskRepository.deleteById(taskId);
        return "redirect:/";
    }

}
