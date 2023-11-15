package com.example.taskmanager.repository;
import com.example.taskmanager.model.Priority;
import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
