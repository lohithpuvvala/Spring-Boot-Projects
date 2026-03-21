package com.lohithpuvvala.Team_Task_Manager.repository;

import com.lohithpuvvala.Team_Task_Manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> { }
