package com.example.atto.service;

import com.example.atto.dto.CardDto;
import com.example.atto.entity.Card;
import com.example.atto.mapper.CardMapper;
import com.example.atto.model.ResMessage;
import com.example.atto.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public ResMessage save(CardDto cardDto){
        Card card = cardMapper.toEntity(cardDto);
        Card save = cardRepository.save(card);
        return new ResMessage(200,"Save",save);
    }
    @Transactional
    public ResMessage balance(CardDto cardDto){
        Card card = cardMapper.toEntity(cardDto);
        Optional<Card> optionalCard = cardRepository.findById(card.getId());
        Double balance = optionalCard.get().getBalance();
        Double balance1 = card.getBalance();
        card = optionalCard.get();
        card.setBalance(balance + balance1);
        Card save = cardRepository.save(card);
        return new ResMessage(200,"has been paid",save);
    }
    public ResMessage getById(Integer id){
        Optional<Card> card = cardRepository.findById(id);
        if (card.isPresent()){
            Card card1 = card.get();
            CardDto cardDto = cardMapper.toDto(card1);
            return new ResMessage(200,"Ok",cardDto);
        }
        return new ResMessage(0,"not found",null);
    }
    public ResMessage getAll(){
        List<Card> card = cardRepository.findAll();
        List<CardDto> cardDto = cardMapper.toDto(card);
        return new ResMessage(200,"Ok",cardDto);
    }
    public ResMessage MoreSpentCard(){
        List<Map<String, Object>> stringObjectMap = cardRepository.findByMoreSpentCard();
        return new ResMessage(200,"Ok",stringObjectMap);
    }
}
