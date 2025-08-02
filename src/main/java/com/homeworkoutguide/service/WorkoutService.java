package com.homeworkoutguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeworkoutguide.model.Workout;
import com.homeworkoutguide.repository.WorkoutRepository;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    public Workout updateWorkout(Workout workout) {
        Workout existing = workoutRepository.findById(workout.getId())
            .orElseThrow(() -> new RuntimeException("Workout not found"));
        existing.setName(workout.getName());
        existing.setDescription(workout.getDescription());
        existing.setDifficulty(workout.getDifficulty());
        existing.setBodyPart(workout.getBodyPart());
        existing.setDuration(workout.getDuration());
        existing.setCalories(workout.getCalories());
        existing.setInstructions(workout.getInstructions());
        existing.setEquipment(workout.getEquipment());
        existing.setVideoUrl(workout.getVideoUrl());
        existing.setImageUrl(workout.getImageUrl());
        return workoutRepository.save(existing);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
} 