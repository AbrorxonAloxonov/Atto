package com.example.atto.controller;

import com.example.atto.dto.CardDto;
import com.example.atto.model.ResMessage;
import com.example.atto.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @PostMapping("/add")
    public ResMessage saveCard(@RequestBody CardDto cardDto ){
        return cardService.save(cardDto);
    }
    @PostMapping("/balance")
    public ResMessage balance(@RequestBody CardDto cardDto){
        return cardService.balance(cardDto);
    }
    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return cardService.getById(id);
    }
    @GetMapping("/all")
    public ResMessage getAll(){
        return cardService.getAll();
    }
    @GetMapping("/more")
    public ResMessage moreSpend(){
        return cardService.MoreSpentCard();
    }
}
