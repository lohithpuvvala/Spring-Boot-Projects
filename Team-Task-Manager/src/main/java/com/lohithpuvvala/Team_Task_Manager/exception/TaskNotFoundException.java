package com.lohithpuvvala.Team_Task_Manager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TaskNotFoundException extends RuntimeException {
    private String message;

    public TaskNotFoundException() {}

    public TaskNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
