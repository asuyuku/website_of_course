package com.graduation.one.entity;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String title;
    private String content;
    private int userId;
    private int type;
    private String userName;
}
