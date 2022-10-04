package com.example.atto.repository;

import com.example.atto.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer>, JpaSpecificationExecutor<Terminal> {
    @Query(value = "select t.id,count(history.terminal_id) from history join terminal t on t.id = history.terminal_id group by t.id limit 1",nativeQuery = true)
    List<Map<String,Object>> maxValid();
}