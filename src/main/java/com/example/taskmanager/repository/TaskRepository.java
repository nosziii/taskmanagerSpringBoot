package com.example.taskmanager.repository;
import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface TaskRepository extends JpaRepository<Task, UUID>
{
}
