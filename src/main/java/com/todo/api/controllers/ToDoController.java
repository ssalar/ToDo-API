/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.api.controllers;

import com.todo.api.dao.ToDoDao;
import com.todo.api.models.ToDo;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ssalar
 */
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    
    private final ToDoDao dao;
    
    public ToDoController(ToDoDao dao){
        this.dao = dao;
    }
    
    @GetMapping
    public List<ToDo> all() {
        return dao.getAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo create(@RequestBody ToDo todo) {
        return dao.add(todo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable int id) {
        ToDo result = dao.findById(id);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    
}
