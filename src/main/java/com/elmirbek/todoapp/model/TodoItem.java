package com.elmirbek.todoapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    Long id;
    String title;
}
