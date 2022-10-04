package com.example.atto.service;

import com.example.atto.dto.HistoryDto;
import com.example.atto.entity.History;
import com.example.atto.mapper.HistoryMapper;
import com.example.atto.model.ResMessage;
import com.example.atto.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    @Transactional
    public ResMessage addHistory(History history){
        History save = historyRepository.save(history);
        return new ResMessage(200,"Save",save);
    }
    @Transactional
    public ResMessage getAll(){
        List<History> history = historyRepository.findAll();
        List<HistoryDto> historyDto = historyMapper.toDto(history);
        return new ResMessage(200,"Ok",historyDto);
    }
    @Transactional
    public ResMessage getById(Integer id){
        Optional<History> optional = historyRepository.findById(id);
        History history = optional.get();
        HistoryDto historyDto = historyMapper.toDto(history);
        return new ResMessage(200,"Ok",historyDto);
    }
}
