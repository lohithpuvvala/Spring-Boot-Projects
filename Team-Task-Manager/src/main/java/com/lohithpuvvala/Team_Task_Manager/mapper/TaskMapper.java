package com.lohithpuvvala.Team_Task_Manager.mapper;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.model.Task;

public class TaskMapper {
    public CompressedTaskDto toCreateTaskDto(Task task) {
        return new CompressedTaskDto(task.getTitle(), task.getDescription());
    }

    public Task CompressedTasktoEntity(CompressedTaskDto compressedTaskDto, Integer id) {
        return new  Task(id, compressedTaskDto.getTitle(), compressedTaskDto.getDescription());
    }
}
