package com.example.atto.dto;

import com.example.atto.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalDto {
    private Integer id;
    private Station station;
    private Date createdDate;
    boolean isActive = true;
}