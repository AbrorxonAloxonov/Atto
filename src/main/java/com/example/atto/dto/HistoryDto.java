package com.example.atto.dto;

import com.example.atto.entity.Card;
import com.example.atto.entity.Terminal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto {
    private Integer id;
    private Terminal terminal;
    private Card card;
    private Date createdDate;
    boolean isActive = true;
}