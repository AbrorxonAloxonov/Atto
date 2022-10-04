package com.example.atto.mapper;

import com.example.atto.dto.CardDto;
import com.example.atto.dto.TerminalDto;
import com.example.atto.entity.Card;
import com.example.atto.entity.Terminal;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TerminalMapper extends EntityMapper<TerminalDto, Terminal> {

}