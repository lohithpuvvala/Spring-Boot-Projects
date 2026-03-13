package com.lohithpuvvala.Team_Task_Manager.repository;

import com.lohithpuvvala.Team_Task_Manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> { }
