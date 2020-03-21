package com.graduation.one.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员 实体类
 *
 * @author makejava
 * @since 2019-12-31 13:31:49
 */
@Data
public class AdminUser implements Serializable {
    private static final long serialVersionUID = 169489466706161258L;

    //id
    private Integer adminId;

    //姓名
    private String userName;

    //用户名
    private String adminName;

    //手机号
    private String adminPhone;

    //密码
    private String password;

    //账号状态
    private Integer dataState;

    //账号类型 1老师 2学生
    private Integer type;

    private Integer teacherId;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    /**
     * 是否被禁用
     */
    public boolean isDisabled(){
        return dataState == 3;
    }

}