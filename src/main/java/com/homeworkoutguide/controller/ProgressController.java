package com.homeworkoutguide.controller;

import java.security.Principal;
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

import com.homeworkoutguide.model.Progress;
import com.homeworkoutguide.service.ProgressService;

@RestController
@RequestMapping("/api")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/progress")
    public ResponseEntity<Progress> markWorkoutComplete(@RequestBody Progress progress, Principal principal) {
        // Set the current date if not provided
        if (progress.getDate() == null) {
            progress.setDate(java.time.LocalDate.now());
        }
        return ResponseEntity.ok(progressService.createProgress(progress));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/progress/complete-workout")
    public ResponseEntity<Progress> completeWorkout(@RequestBody Progress progress, Principal principal) {
        // Set the current date and mark as completed
        progress.setDate(java.time.LocalDate.now());
        progress.setCompleted(true);
        return ResponseEntity.ok(progressService.createProgress(progress));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/progress/user/{userId}")
    public ResponseEntity<List<Progress>> getUserProgress(@PathVariable Long userId) {
        return ResponseEntity.ok(progressService.getProgressByUserId(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/progress")
    public ResponseEntity<List<Progress>> getAllProgress() {
        return ResponseEntity.ok(progressService.getAllProgress());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/progress/detailed")
    public ResponseEntity<List<Progress>> getAllProgressDetailed() {
        return ResponseEntity.ok(progressService.getAllProgressWithDetails());
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/progress/{id}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long id, @RequestBody Progress progress) {
        progress.setId(id);
        return ResponseEntity.ok(progressService.updateProgress(progress));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/progress/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id) {
        progressService.deleteProgress(id);
        return ResponseEntity.noContent().build();
    }
} 