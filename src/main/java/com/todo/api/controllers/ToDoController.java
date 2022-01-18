/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.api.controllers;

import com.todo.api.dao.ToDoDao;
import com.todo.api.models.ToDo;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
