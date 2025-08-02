package com.homeworkoutguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeworkoutguide.model.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    @Query("SELECT p FROM Progress p LEFT JOIN FETCH p.workout WHERE p.user.id = :userId")
    List<Progress> findByUserId(@Param("userId") Long userId);
    
    List<Progress> findByWorkoutId(Long workoutId);
    
    @Query("SELECT p FROM Progress p LEFT JOIN FETCH p.user LEFT JOIN FETCH p.workout")
    List<Progress> findAllWithUserAndWorkoutDetails();
} 