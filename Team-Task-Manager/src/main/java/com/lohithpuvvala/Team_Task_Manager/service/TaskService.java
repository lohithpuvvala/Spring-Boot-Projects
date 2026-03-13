package com.lohithpuvvala.Team_Task_Manager.service;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(CompressedTaskDto compressedTaskDto);
    Task getTaskById(Integer id);
    List<Task> getAllTasks();
    void updateTaskById(Integer id, CompressedTaskDto compressedTaskDto);
    void deleteTaskById(Integer id);
}
