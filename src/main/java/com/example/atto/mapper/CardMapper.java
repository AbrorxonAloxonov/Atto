package com.example.atto.mapper;

import com.example.atto.dto.CardDto;
import com.example.atto.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CardMapper extends EntityMapper<CardDto, Card> {
    CardDto toDto(Card entity);
}