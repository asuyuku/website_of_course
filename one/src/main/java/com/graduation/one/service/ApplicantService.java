package com.graduation.one.service;

import com.graduation.one.entity.Applicant;
import java.util.List;

/**
 * (Applicant)表服务接口
 *
 * @author makejava
 * @since 2019-12-31 14:29:31
 */
public interface ApplicantService {

    /**
     * 通过ID查询单条数据
     *
     * @param applicantId 主键
     * @return 实例对象
     */
    Applicant queryById(Integer applicantId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Applicant> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param applicant 实例对象
     * @return 实例对象
     */
    Applicant insert(Applicant applicant);

    /**
     * 修改数据
     *
     * @param applicant 实例对象
     * @return 实例对象
     */
    Applicant update(Applicant applicant);

    /**
     * 通过主键删除数据
     *
     * @param applicantId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer applicantId);

}