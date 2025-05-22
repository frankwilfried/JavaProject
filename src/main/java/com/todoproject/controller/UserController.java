package com.todoproject.controller;

import com.todoproject.entity.Todo;
import com.todoproject.entity.User;
import com.todoproject.repository.Todo_Repository;
import com.todoproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final Todo_Repository todoRepository;
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
    }

    @PostMapping("/{userId}/todos")
    public void addToDo(@PathVariable Long userId, @RequestBody Todo todo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        todo.setUser(user); // associer le todo à l'utilisateur
        todoRepository.save(todo);
    }

    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("Todo not found"));
        todo.setCompleted(!todo.getCompleted()); // inverse l'état
        todoRepository.save(todo);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("Todo not found"));
        todoRepository.delete(todo);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
        userRepository.delete(user);
    }
}
