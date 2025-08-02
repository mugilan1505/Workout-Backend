package com.homeworkoutguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeworkoutguide.model.Progress;
import com.homeworkoutguide.repository.ProgressRepository;

@Service
public class ProgressService {
    @Autowired
    private ProgressRepository progressRepository;

    public Progress createProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public List<Progress> getAllProgressWithDetails() {
        return progressRepository.findAllWithUserAndWorkoutDetails();
    }

    public Optional<Progress> getProgressById(Long id) {
        return progressRepository.findById(id);
    }

    public List<Progress> getProgressByUserId(Long userId) {
        return progressRepository.findByUserId(userId);
    }

    public List<Progress> getProgressByWorkoutId(Long workoutId) {
        return progressRepository.findByWorkoutId(workoutId);
    }

    public Progress updateProgress(Progress progress) {
        Progress existing = progressRepository.findById(progress.getId())
            .orElseThrow(() -> new RuntimeException("Progress not found"));
        existing.setUser(progress.getUser());
        existing.setWorkout(progress.getWorkout());
        existing.setDate(progress.getDate());
        existing.setCompleted(progress.isCompleted());
        existing.setDurationMinutes(progress.getDurationMinutes());
        existing.setCaloriesBurned(progress.getCaloriesBurned());
        existing.setNotes(progress.getNotes());
        return progressRepository.save(existing);
    }

    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }
} 