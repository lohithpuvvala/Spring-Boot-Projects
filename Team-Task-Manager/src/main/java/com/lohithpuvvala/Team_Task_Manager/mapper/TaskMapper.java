package com.lohithpuvvala.Team_Task_Manager.mapper;

import com.lohithpuvvala.Team_Task_Manager.dto.CompressedTaskDto;
import com.lohithpuvvala.Team_Task_Manager.dto.ViewTaskDto;
import com.lohithpuvvala.Team_Task_Manager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public CompressedTaskDto toCompressedTaskDto(Task task) {
        return new CompressedTaskDto(task.getTitle(), task.getDescription());
    }

    public Task CompressedTasktoEntity(CompressedTaskDto compressedTaskDto, Integer id) {
        return new  Task(id, compressedTaskDto.getTitle(), compressedTaskDto.getDescription());
    }

    public ViewTaskDto toViewTaskDto(Task task) {
        return new ViewTaskDto(task);
    }

    public List<ViewTaskDto> toViewTaskDto(List<Task> tasks) {
        List<ViewTaskDto> viewTaskDtos = new ArrayList<>();
        for (Task task : tasks) {
            viewTaskDtos.add(toViewTaskDto(task));
        }
        return viewTaskDtos;
    }

    public Task toEntity(ViewTaskDto viewTaskDto) {
        return new Task(
                viewTaskDto.getId(),
                viewTaskDto.getDetails().getTitle(),
                viewTaskDto.getDetails().getDescription()
        );
    }
}
