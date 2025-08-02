package com.homeworkoutguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeworkoutguide.model.DietPlan;
import com.homeworkoutguide.service.DietPlanService;

@RestController
@RequestMapping("/api")
public class DietPlanController {
    @Autowired
    private DietPlanService dietPlanService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/dietplans")
    public ResponseEntity<DietPlan> createDietPlan(@RequestBody DietPlan dietPlan) {
        return ResponseEntity.ok(dietPlanService.createDietPlan(dietPlan));
    }

    @GetMapping("/dietplans")
    public ResponseEntity<List<DietPlan>> getAllDietPlans() {
        return ResponseEntity.ok(dietPlanService.getAllDietPlans());
    }

    @GetMapping("/dietplans/{id}")
    public ResponseEntity<DietPlan> getDietPlanById(@PathVariable Long id) {
        return dietPlanService.getDietPlanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/admin/dietplans/{id}")
    public ResponseEntity<DietPlan> updateDietPlan(@PathVariable Long id, @RequestBody DietPlan dietPlan) {
        dietPlan.setId(id);
        return ResponseEntity.ok(dietPlanService.updateDietPlan(dietPlan));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/dietplans/{id}")
    public ResponseEntity<Void> deleteDietPlan(@PathVariable Long id) {
        dietPlanService.deleteDietPlan(id);
        return ResponseEntity.noContent().build();
    }
} 