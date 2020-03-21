package com.graduation.one.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * (Answer)实体类
 *
 * @author makejava
 * @since 2020-03-18 23:28:04
 */
@Data
public class Answer implements Serializable {
    private static final long serialVersionUID = -31344455728026452L;
    
    private Integer id;
    
    private Integer userId;
    
    private String content;
    
    private String fileName;
    
    private Integer homeworkId;

    private MultipartFile file;
    
    private String fileNameTwo;
    private String userName;
    /**
    *  状态  0为已提交 1为已批改
    */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getFileNameTwo() {
        return fileNameTwo;
    }

    public void setFileNameTwo(String fileNameTwo) {
        this.fileNameTwo = fileNameTwo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}