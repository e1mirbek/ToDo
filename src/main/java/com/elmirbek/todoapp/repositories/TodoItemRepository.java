package com.elmirbek.todoapp.repositories;

import com.elmirbek.todoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository <TodoItem, Long> {

}
