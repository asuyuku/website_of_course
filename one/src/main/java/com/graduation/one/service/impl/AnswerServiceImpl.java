package com.graduation.one.service.impl;

import com.graduation.one.entity.Answer;
import com.graduation.one.dao.AnswerDao;
import com.graduation.one.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Answer)表服务实现类
 *
 * @author makejava
 * @since 2020-03-18 23:28:06
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerDao answerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Answer queryById(Integer id) {
        return this.answerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Answer> queryAllByLimit(int offset, int limit) {
        return this.answerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    @Override
    public Answer insert(Answer answer) {
        this.answerDao.insert(answer);
        return answer;
    }

    @Override
    public List<Answer> queryAll(Answer answer) {
        return answerDao.queryAll(answer);
    }

    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    @Override
    public Answer update(Answer answer) {
        this.answerDao.update(answer);
        return this.queryById(answer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.answerDao.deleteById(id) > 0;
    }
}