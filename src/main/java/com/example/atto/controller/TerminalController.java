package com.example.atto.controller;

import com.example.atto.model.ResMessage;
import com.example.atto.service.TerminalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terminal")
@AllArgsConstructor
public class TerminalController {
    private final TerminalService terminalService;
    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return terminalService.getById(id);
    }
    @GetMapping("/all")
    public ResMessage getAll(){
        return terminalService.getAll();
    }
    @PostMapping("/pay")
    public ResMessage terminal(@RequestParam Integer card_id, @RequestParam Integer terminal_id){
        return terminalService.terminal(card_id,terminal_id);
    }
    @GetMapping("/max")
    public ResMessage maxValid(){
        return terminalService.maxValid();
    }
}
