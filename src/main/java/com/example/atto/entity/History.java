package com.example.atto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class History extends BasicEntity{
    @ManyToOne
    private Terminal terminal;
    @ManyToOne
    private Card card;
}
