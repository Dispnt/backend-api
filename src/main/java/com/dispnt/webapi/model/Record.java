package com.dispnt.webapi.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Record {
    @Id //主键标注
    @Column(name = "time_date") //表明是Record表内的id列
    @GeneratedValue //可以自动增减吧，我也不知道
    private Timestamp timeDate;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;
}
