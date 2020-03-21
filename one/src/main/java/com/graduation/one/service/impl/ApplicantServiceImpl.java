package com.graduation.one.service.impl;

import com.graduation.one.entity.Applicant;
import com.graduation.one.dao.ApplicantDao;
import com.graduation.one.service.ApplicantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Applicant)表服务实现类
 *
 * @author makejava
 * @since 2019-12-31 14:29:31
 */
@Service("applicantService")
public class ApplicantServiceImpl implements ApplicantService {
    @Resource
    private ApplicantDao applicantDao;

    /**
     * 通过ID查询单条数据
     *
     * @param applicantId 主键
     * @return 实例对象
     */
    @Override
    public Applicant queryById(Integer applicantId) {
        return this.applicantDao.queryById(applicantId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Applicant> queryAllByLimit(int offset, int limit) {
        return this.applicantDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param applicant 实例对象
     * @return 实例对象
     */
    @Override
    public Applicant insert(Applicant applicant) {
        this.applicantDao.insert(applicant);
        return applicant;
    }

    /**
     * 修改数据
     *
     * @param applicant 实例对象
     * @return 实例对象
     */
    @Override
    public Applicant update(Applicant applicant) {
        this.applicantDao.update(applicant);
        return this.queryById(applicant.getApplicantId());
    }

    /**
     * 通过主键删除数据
     *
     * @param applicantId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer applicantId) {
        return this.applicantDao.deleteById(applicantId) > 0;
    }
}