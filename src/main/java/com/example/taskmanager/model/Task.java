package com.example.taskmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Task {

    @Id
    private UUID id;
    private String name;
    private String description;
    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //konstruktor
    public Task() {

    }
    public Task(String name, String description, Priority priority, LocalDateTime dueDate) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.createAt = LocalDateTime.now();
    }

    //Getterek és Setterek
    public UUID getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
