package com.graduation.one.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Data
public class Homework {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private String userName;
    private MultipartFile file;
    private String fileName;
}
