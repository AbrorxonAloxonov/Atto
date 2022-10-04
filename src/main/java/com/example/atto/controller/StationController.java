package com.example.atto.controller;

import com.example.atto.dto.StationDto;
import com.example.atto.model.ResMessage;
import com.example.atto.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class StationController {
    private final StationService  stationService;
    @PostMapping("/add")
    public ResMessage addStation(@RequestBody StationDto stationDto){
        return stationService.addStation(stationDto);
    }
    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return stationService.getById(id);
    }
    @GetMapping("/all")
    public ResMessage getAllStation(){
        return stationService.getAllStation();
    }
    @GetMapping("/money")
    public ResMessage getReport(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate ){
        return stationService.getMoney(fromDate,toDate);
    }
}
