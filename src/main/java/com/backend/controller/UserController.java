package com.backend.controller;

import com.backend.dto.request.UserCreationRequest;
import com.backend.dto.request.UserUpdateRequest;
import com.backend.entity.User;
import com.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    User createUser(@RequestBody @Valid UserCreationRequest request) {
       return userService.createRequest(request);
    }

    @GetMapping()
    List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateRequest(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId) {
        userService.removeUser(userId);
        return "User has been deleted";
    }
}
