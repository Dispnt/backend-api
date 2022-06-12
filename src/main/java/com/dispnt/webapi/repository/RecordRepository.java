package com.dispnt.webapi.repository;
import com.dispnt.webapi.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;



public interface RecordRepository extends JpaRepository<Record, Timestamp> {

    Record findByTimeDate(Timestamp timestamp);

    List<Record> findByTimeDateBetween(Timestamp start, Timestamp end);

    Record findByMessage(String message);
    List<Record> findByMessageLike(String message);
}
