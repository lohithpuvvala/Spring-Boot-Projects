package com.lohithpuvvala.Team_Task_Manager.service.impl;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.mapper.TaskMapper;
import com.lohithpuvvala.Team_Task_Manager.model.Task;
import com.lohithpuvvala.Team_Task_Manager.repository.TaskRepository;
import com.lohithpuvvala.Team_Task_Manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void updateTaskById(Integer id, CompressedTaskDto compressedTaskDto){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()) {
            Task updatedTask = taskMapper.CompressedTasktoEntity(compressedTaskDto,id);
            taskRepository.save(updatedTask);
        }else{
            throw new RuntimeException("Service Layer: Task with id " + id + " not found");
        }
    }

    @Override
    public void deleteTaskById(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()) {
            taskRepository.delete(task.get());
        }else{
            throw new RuntimeException("Service Layer: Task with id " + id + " not found");
        }
    }
}
