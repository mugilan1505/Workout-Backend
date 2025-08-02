package com.homeworkoutguide.dto;

import com.homeworkoutguide.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private User user;
}