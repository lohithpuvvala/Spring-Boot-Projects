package com.lohithpuvvala.Team_Task_Manager.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewTaskDto {
    private Integer id;
    private CompressedTaskDto compressedTaskDto;
}
