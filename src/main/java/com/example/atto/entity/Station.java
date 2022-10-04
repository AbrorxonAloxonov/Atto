package com.example.atto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Station extends BasicEntity{
    private String name;
    private Integer terminalSize;
    private Double balance;
}
