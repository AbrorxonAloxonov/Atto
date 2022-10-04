package com.example.atto.repository;

import com.example.atto.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>, JpaSpecificationExecutor<Station> {
    @Query(value = "select s.id,s.name,s.balance from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id where h.created_date between ? and ? group by s.name, s.balance, s.id order by s.balance desc limit 2",nativeQuery = true)
    List<Map<String,Object>> findByCreatedDateBetweenStation(Date fromDate, Date toDate);
}