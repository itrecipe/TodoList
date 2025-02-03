package com.toy.todo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Todos {
    private Long no;
    private String id;
    private String name;
    private Boolean status;
    private Integer seq;
    private Date createdAt;
    private Date updatedAt;
}
