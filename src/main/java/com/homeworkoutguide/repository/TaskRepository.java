package com.homeworkoutguide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeworkoutguide.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
} 