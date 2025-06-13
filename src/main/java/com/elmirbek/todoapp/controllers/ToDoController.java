package com.elmirbek.todoapp.controllers;
import com.elmirbek.todoapp.model.TodoItem;
import com.elmirbek.todoapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ToDoController implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public ToDoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
   public String index (Model model) {
      List<TodoItem> allTodos = todoItemRepository.findAll();
      model.addAttribute("allTodos", allTodos);
      model.addAttribute("newTodo", new TodoItem());


        return "index";
    }


    // добавление задачи
    @PostMapping("/add")
    public String add(@ModelAttribute  TodoItem todoItem){
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    // удаление задачи
    @PostMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        todoItemRepository.deleteById(id);
        return "redirect:/";
    }




    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new TodoItem("Задача 1"));
        todoItemRepository.save(new TodoItem("Задача 2"));
        todoItemRepository.save(new TodoItem("Задача 3"));
    }
}
