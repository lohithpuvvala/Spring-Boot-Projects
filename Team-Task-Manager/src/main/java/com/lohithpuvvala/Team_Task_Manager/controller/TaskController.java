package com.lohithpuvvala.Team_Task_Manager.controller;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.mapper.TaskMapper;
import com.lohithpuvvala.Team_Task_Manager.model.Task;
import com.lohithpuvvala.Team_Task_Manager.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task-api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    private final TaskMapper taskMapper = new TaskMapper();

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody CompressedTaskDto compressedTaskDto) {
        return new ResponseEntity<>(taskService.createTask(compressedTaskDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(),  HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<CompressedTaskDto> getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);
        if(task == null){
            throw new RuntimeException("Controller Layer: Task with id " + id + " not found");
        }
        return new ResponseEntity<>(taskMapper.toCompressedTaskDto(task), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Integer id, @RequestBody CompressedTaskDto compressedTaskDto) {
        taskService.updateTaskById(id,compressedTaskDto);
        return new ResponseEntity<>("Task updated", HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }
}
