package com.example.atto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card extends BasicEntity{
    private String cardNumber;
    private String phone;
    private Double balance;

    public Card(Integer id,String cardNumber, String phone, Double balance,boolean isActive) {
        super.setId(id);
        this.cardNumber = cardNumber;
        this.phone = phone;
        this.balance = balance;
        this.isActive = isActive;
    }
}
