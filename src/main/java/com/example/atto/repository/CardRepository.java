package com.example.atto.repository;

import com.example.atto.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>, JpaSpecificationExecutor<Card> {
    @Query(value = "select c.id,c.card_number from history h left join card c on c.id = h.card_id group by h.card_id, c.card_number, c.id order by count(h.card_id) desc limit 2",nativeQuery = true)
    List<Map<String,Object>> findByMoreSpentCard();
}