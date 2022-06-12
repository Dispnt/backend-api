package com.dispnt.webapi.controller;


import com.dispnt.webapi.model.Record;
import com.dispnt.webapi.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("/record")
@CrossOrigin("*")
@RestController
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;

    /**
     * search by time
     */
    @GetMapping("/time")
    public List<Record> getTime(@RequestParam("start") String t1,@RequestParam("end") String t2) throws Exception{
//        2015-10-23 20:16:45 - 2015-10-23 23:46:51
        Timestamp time_start = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1).getTime());
        Timestamp time_end = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2).getTime());
        List<Record> record = recordRepository.findByTimeDateBetween(time_start,time_end);
        return record;
    }


    /**
     * search by content
     */
    @GetMapping("/msg")
    public List<Record> getMessage(@RequestParam("message") String td){
        List<Record> record = recordRepository.findByMessageLike("%"+td+"%");
        System.out.println(record);
        return record;
    }
}
