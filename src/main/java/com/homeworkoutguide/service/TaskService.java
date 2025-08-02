package com.homeworkoutguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeworkoutguide.model.Task;
import com.homeworkoutguide.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Task task) {
        Task existing = taskRepository.findById(task.getId())
            .orElseThrow(() -> new RuntimeException("Task not found"));
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setWorkout(task.getWorkout());
        return taskRepository.save(existing);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
} 