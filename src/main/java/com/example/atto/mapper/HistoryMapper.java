package com.example.atto.mapper;

import com.example.atto.dto.HistoryDto;
import com.example.atto.entity.History;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface HistoryMapper extends EntityMapper<HistoryDto, History> {
}