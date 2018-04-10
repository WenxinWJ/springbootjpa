package com.springbootjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity // 说明此类是实体类
@Table(name = "MOVIE")  // 说明实体类对应的表名
public class Movie implements Serializable {
    private static final long serialVersionUID = 4495336182184800175L;

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.AUTO) // Id 的值自动增长
    private Integer id;

    // 说明类中的属性对应表中的字段(字段名，长度，null)
    //@Column(name = "movie_name",length = 100,nullable = true)
    @Column // 默认 属性名和字段名一致
    private String name;

    @Column
    private Double price;

    @Column(name = "action_time") // 不一致时要添加
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date actionTime;

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", actionTime=" + actionTime +
                '}';
    }
}
