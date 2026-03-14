package com.lohithpuvvala.Team_Task_Manager.dto;


import com.lohithpuvvala.Team_Task_Manager.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewTaskDto {
    private Integer id;
    private CompressedTaskDto compressedTaskDto;

    public ViewTaskDto(Task task) {
        this.id = task.getId();
        this.compressedTaskDto.setTitle(task.getTitle());
        this.compressedTaskDto.setDescription(task.getDescription());
    }
}
