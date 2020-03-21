package com.graduation.one.service;

import com.graduation.one.entity.AdminUser;
import java.util.List;

/**
 * (AdminUser)表服务接口
 *
 * @author makejava
 * @since 2019-12-31 14:31:41
 */
public interface AdminUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    AdminUser queryById(Integer adminId);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<AdminUser> queryAllByLimit();

    List<AdminUser> queryAll(AdminUser adminUser);
    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser insert(AdminUser adminUser);

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser update(AdminUser adminUser);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adminId);

    /**
     * 获取登录用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return 登录用户
     */
    AdminUser login(String userName,String password);

    /**
     * 检测用户名是否存在
     *
     * @param adminUser 用户名
     * @return 是否
     */
    boolean isExisted(AdminUser adminUser);
}