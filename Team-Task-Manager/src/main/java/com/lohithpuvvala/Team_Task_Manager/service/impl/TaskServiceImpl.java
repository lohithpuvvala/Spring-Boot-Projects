package com.lohithpuvvala.Team_Task_Manager.service.impl;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.exception.TaskNotFoundException;
import com.lohithpuvvala.Team_Task_Manager.mapper.TaskMapper;
import com.lohithpuvvala.Team_Task_Manager.model.Task;
import com.lohithpuvvala.Team_Task_Manager.repository.TaskRepository;
import com.lohithpuvvala.Team_Task_Manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper = new TaskMapper();

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CompressedTaskDto compressedTaskDto) {
        Task task = new Task();
        task.setTitle(compressedTaskDto.getTitle());
        task.setDescription(compressedTaskDto.getDescription());
        return  taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task with id: " + id + " not found")
        );
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void updateTaskById(Integer id, CompressedTaskDto compressedTaskDto){
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException("Task with id: " + id + " not found");
        }
        Task updatedTask = taskMapper.CompressedTasktoEntity(compressedTaskDto,id);
        taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTaskById(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task with id: " + id + " not found")
        );
        taskRepository.delete(task);
    }
}
