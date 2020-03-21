package com.graduation.one.dao;

import com.graduation.one.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AdminUser)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-31 14:31:40
 */
public interface AdminUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    AdminUser queryById(Integer adminId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
//    List<AdminUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    List<AdminUser> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminUser 实例对象
     * @return 对象列表
     */
    List<AdminUser> queryAll(AdminUser adminUser);

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 影响行数
     */
    int insert(AdminUser adminUser);

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 影响行数
     */
    int update(AdminUser adminUser);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 影响行数
     */
    int deleteById(Integer adminId);

    /**
     * 获取登录用户对象
     *
     * @param userName 用户名
     * @param password 密码
     * @return 登录用户对象
     */
    AdminUser getLoginAdminUser(@Param("userName") String userName,@Param("password") String password);

    /**
     * 返回该用户名数量
     *
     * @param adminUser 用户名
     * @return 数量
     */
    int isExisted(AdminUser adminUser);

}