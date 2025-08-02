package com.homeworkoutguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeworkoutguide.model.DietPlan;
import com.homeworkoutguide.repository.DietPlanRepository;

@Service
public class DietPlanService {
    @Autowired
    private DietPlanRepository dietPlanRepository;

    public DietPlan createDietPlan(DietPlan dietPlan) {
        return dietPlanRepository.save(dietPlan);
    }

    public List<DietPlan> getAllDietPlans() {
        return dietPlanRepository.findAll();
    }

    public Optional<DietPlan> getDietPlanById(Long id) {
        return dietPlanRepository.findById(id);
    }

    public DietPlan updateDietPlan(DietPlan dietPlan) {
        DietPlan existing = dietPlanRepository.findById(dietPlan.getId())
            .orElseThrow(() -> new RuntimeException("DietPlan not found"));
        existing.setName(dietPlan.getName());
        existing.setDescription(dietPlan.getDescription());
        existing.setCalories(dietPlan.getCalories());
        return dietPlanRepository.save(existing);
    }

    public void deleteDietPlan(Long id) {
        dietPlanRepository.deleteById(id);
    }
} 