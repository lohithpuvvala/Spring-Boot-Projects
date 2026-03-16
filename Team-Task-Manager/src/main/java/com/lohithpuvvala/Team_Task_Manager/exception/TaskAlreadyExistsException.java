package com.lohithpuvvala.Team_Task_Manager.exception;

public class TaskAlreadyExistsException extends RuntimeException {
    private String message;

    public TaskAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
