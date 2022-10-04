package com.example.atto.mapper;


import com.example.atto.dto.StationDto;
import com.example.atto.entity.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper extends EntityMapper<StationDto, Station> {
}