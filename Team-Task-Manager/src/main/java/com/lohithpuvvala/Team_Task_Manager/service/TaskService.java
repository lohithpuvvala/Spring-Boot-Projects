package com.lohithpuvvala.Team_Task_Manager.service;

import com.lohithpuvvala.Team_Task_Manager.model.Task;

import java.util.ArrayList;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Integer id);
    ArrayList<Task> getAllTasks();
    Task updateTaskById(Integer id, Task task);
    void deleteTaskById(Integer id);
}
