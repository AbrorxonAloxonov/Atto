package com.example.atto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Integer id;
    private String cardNumber;
    private String phone;
    private Double balance;
    private Date createdDate;
    boolean isActive = true;
}