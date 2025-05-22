package com.todoproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id ;
    private String name ;
    private boolean completed= Boolean.FALSE ;

    public boolean getCompleted() {
        return false;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public void setUser(User user) {
    }
}
