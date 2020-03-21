package com.graduation.one.dao;

import com.graduation.one.entity.Applicant;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Applicant)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-31 14:29:31
 */
public interface ApplicantDao {

    /**
     * 通过ID查询单条数据
     *
     * @param applicantId 主键
     * @return 实例对象
     */
    Applicant queryById(Integer applicantId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Applicant> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param applicant 实例对象
     * @return 对象列表
     */
    List<Applicant> queryAll(Applicant applicant);

    /**
     * 新增数据
     *
     * @param applicant 实例对象
     * @return 影响行数
     */
    int insert(Applicant applicant);

    /**
     * 修改数据
     *
     * @param applicant 实例对象
     * @return 影响行数
     */
    int update(Applicant applicant);

    /**
     * 通过主键删除数据
     *
     * @param applicantId 主键
     * @return 影响行数
     */
    int deleteById(Integer applicantId);

}