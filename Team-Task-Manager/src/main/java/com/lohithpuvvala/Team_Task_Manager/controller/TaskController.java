package com.lohithpuvvala.Team_Task_Manager.controller;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.mapper.TaskMapper;
import com.lohithpuvvala.Team_Task_Manager.model.Task;
import com.lohithpuvvala.Team_Task_Manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task-api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    private final TaskMapper taskMapper = new TaskMapper();

    @PostMapping("/tasks")
    public Task createTask(@RequestBody CompressedTaskDto compressedTaskDto) {
        return taskService.createTask(compressedTaskDto);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);
        if(task == null){
            throw new RuntimeException("Controller Layer: Task with id " + id + " not found");
        }
        return task;
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Integer id, @RequestBody CompressedTaskDto compressedTaskDto) {
        taskService.updateTaskById(id,compressedTaskDto);
        return "Task updated";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return "Task deleted";
    }
}
