package com.example.atto.controller;

import com.example.atto.model.ResMessage;
import com.example.atto.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("history")
@AllArgsConstructor
public class HistoryController {
    private final HistoryService historyService;
    @GetMapping("terminal/{id}")
    public ResMessage findById(@PathVariable Integer id){
        return historyService.getById(id);
    }
    @GetMapping("/all")
    public ResMessage getAll(){
        return historyService.getAll();
    }
}
