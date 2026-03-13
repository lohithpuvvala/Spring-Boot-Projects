package com.lohithpuvvala.Team_Task_Manager.service.impl;

import com.lohithpuvvala.Team_Task_Manager.model.Task;
import com.lohithpuvvala.Team_Task_Manager.repository.TaskRepository;
import com.lohithpuvvala.Team_Task_Manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task getTaskById(Integer id) {
        return null;
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task updateTaskById(Integer id, Task task) {
        return null;
    }

    @Override
    public void deleteTaskById(Integer id) {

    }
}
