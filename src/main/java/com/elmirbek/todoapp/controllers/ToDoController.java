package com.elmirbek.todoapp.controllers;
import com.elmirbek.todoapp.model.TodoItem;
import com.elmirbek.todoapp.repositories.TodoItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ToDoController {

    private final TodoItemRepository todoItemRepository;

    public ToDoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
   public String index (Model model) {
        todoItemRepository.save(new TodoItem("Item 1"));
        todoItemRepository.save(new TodoItem("Item 2"));
        todoItemRepository.save(new TodoItem("Item 3"));

      List<TodoItem> allTodos = todoItemRepository.findAll();
      model.addAttribute("allTodos", allTodos);


        return "index";
    }
}
