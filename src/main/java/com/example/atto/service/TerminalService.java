package com.example.atto.service;

import com.example.atto.dto.CardDto;
import com.example.atto.dto.StationDto;
import com.example.atto.dto.TerminalDto;
import com.example.atto.entity.Card;
import com.example.atto.entity.History;
import com.example.atto.entity.Station;
import com.example.atto.entity.Terminal;
import com.example.atto.mapper.CardMapper;
import com.example.atto.mapper.StationMapper;
import com.example.atto.mapper.TerminalMapper;
import com.example.atto.model.ResMessage;
import com.example.atto.repository.CardRepository;
import com.example.atto.repository.TerminalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final CardRepository cardRepository;
    private final TerminalMapper terminalMapper;
    private final StationService stationService;
    private final CardMapper cardMapper;
    private final CardService cardService;
    private final StationMapper stationMapper;
    private final HistoryService historyService;
    public ResMessage getById(Integer id){
        Optional<Terminal> byId = terminalRepository.findById(id);
        return new ResMessage(200,"ok",byId);
    }
    @Transactional
    public ResMessage getAll(){
        List<Terminal> terminal = terminalRepository.findAll();
        List<TerminalDto> terminalDto = terminalMapper.toDto(terminal);
        return new ResMessage(200,"Ok",terminalDto);
    }
    @Transactional
    public ResMessage terminal(Integer card_id,Integer terminal_id){
        Optional<Card> card = cardRepository.findById(card_id);
        Optional<Terminal> terminal = terminalRepository.findById(terminal_id);
        if(card.isPresent() && card.get().getBalance() >= 1400 && terminal.isPresent()){
            Card card1 = card.get();
            CardDto cardDto = cardMapper.toDto(card1);
            cardDto.setBalance(cardDto.getBalance() - 1400);

            Station station = terminal.get().getStation();
            station.setBalance(station.getBalance() + 1400);
            StationDto stationDto = stationMapper.toDto(station);

            Terminal terminal1 = terminal.get();
            History history = new History();
            history.setTerminal(terminal1);
            history.setCard(card1);

            historyService.addHistory(history);
            cardService.save(cardDto);
            stationService.addStation(stationDto);
            return new ResMessage(200,"has been paid",cardDto);
        }
        return new ResMessage(0,"insufficient funds",null);
   }
    public ResMessage maxValid(){
        List<Map<String, Object>> map = terminalRepository.maxValid();
        if (!map.isEmpty()) {
            return new ResMessage(200,"ok",map);
        }
        return new ResMessage(201,"ok",null);
   }
}
