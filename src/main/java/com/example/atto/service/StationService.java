package com.example.atto.service;

import com.example.atto.dto.StationDto;
import com.example.atto.entity.Station;
import com.example.atto.mapper.StationMapper;
import com.example.atto.model.ResMessage;
import com.example.atto.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StationService {
    private final StationRepository stationRepository;
    private final StationMapper stationMapper;
    @Transactional
    public ResMessage addStation(StationDto stationDto){
        Station station = stationMapper.toEntity(stationDto);
        Station save = stationRepository.save(station);
        return new ResMessage(200,"Save",save);
    }
    @Transactional
    public ResMessage getById(Integer id){
        Optional<Station> station = stationRepository.findById(id);
        Station station1 = station.get();
        StationDto stationDto = stationMapper.toDto(station1);
        return new ResMessage(200,"Ok",stationDto);
    }
    @Transactional
    public ResMessage getAllStation(){
        List<Station> station = stationRepository.findAll();
        List<StationDto> stationList = stationMapper.toDto(station);
        return new ResMessage(200,"Ok",stationList);
    }
    @Transactional
    public ResMessage getMoney(Date date,Date date1){
        List<Map<String, Object>> map = stationRepository.findByCreatedDateBetweenStation(date, date1);
        if (!map.isEmpty()){
            return new ResMessage(200,"Ok",map);
        }
        return new ResMessage(201,"Ok",null);
    }
}
