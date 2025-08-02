package com.homeworkoutguide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeworkoutguide.model.DietPlan;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
} 