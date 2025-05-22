package com.todoproject.repository;

import com.todoproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Todo_Repository extends JpaRepository<Todo, Long> {
}
