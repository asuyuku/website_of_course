package com.graduation.one.entity;

import java.io.Serializable;

/**
 * 党员 实体类
 *
 * @author makejava
 * @since 2019-12-31 14:29:31
 */
public class Applicant implements Serializable {
    private static final long serialVersionUID = -23789816051165404L;
    
    private Integer applicantId;
    
    private String applicantName;
    
    private Integer sex;
    
    private String applicantPhone;
    
    private String applicationAddress;
    
    private String applicantClass;
    
    private Integer age;
    
    private String idNumber;
    
    private String password;
    
    private String userName;


    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicationAddress() {
        return applicationAddress;
    }

    public void setApplicationAddress(String applicationAddress) {
        this.applicationAddress = applicationAddress;
    }

    public String getApplicantClass() {
        return applicantClass;
    }

    public void setApplicantClass(String applicantClass) {
        this.applicantClass = applicantClass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}