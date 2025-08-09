package com.backend.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class UserCreationRequest {
    @Size(min = 3, message = "Username must be at least 3 characters")
    String username;

    @Size(min = 8, message = "Password must be at least 8 characters")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
