package com.homeworkoutguide.repository;

import com.homeworkoutguide.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
} 