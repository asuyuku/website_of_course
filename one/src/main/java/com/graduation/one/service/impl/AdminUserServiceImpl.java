package com.graduation.one.service.impl;

import com.graduation.one.entity.AdminUser;
import com.graduation.one.dao.AdminUserDao;
import com.graduation.one.service.AdminUserService;
import com.graduation.one.utils.Algorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminUser)表服务实现类
 *
 * @author makejava
 * @since 2019-12-31 14:31:42
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    @Override
    public AdminUser queryById(Integer adminId) {
        return this.adminUserDao.queryById(adminId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminUser> queryAllByLimit() {
        return this.adminUserDao.queryAllByLimit();
    }

    @Override
    public List<AdminUser> queryAll(AdminUser adminUser) {
        return this.adminUserDao.queryAll(adminUser);
    }

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    @Override
    public AdminUser insert(AdminUser adminUser) {
        this.adminUserDao.insert(adminUser);
        return adminUser;
    }

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    @Override
    public AdminUser update(AdminUser adminUser) {
        this.adminUserDao.update(adminUser);
        return this.queryById(adminUser.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminId) {
        return this.adminUserDao.deleteById(adminId) > 0;
    }

    /**
     * 获取登录用户对象
     * @param userName 用户名
     * @param password 密码
     * @return 登录用户对象
     */
    @Override
    public AdminUser login(String userName,String password) {
//        password = Algorithm.mD5(password);
        return this.adminUserDao.getLoginAdminUser(userName,password);
    }

    @Override
    public boolean isExisted(AdminUser adminUser) {
        return this.adminUserDao.isExisted(adminUser)>1;
    }
}