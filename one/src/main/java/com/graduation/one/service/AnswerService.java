package com.graduation.one.service;

import com.graduation.one.entity.Answer;
import java.util.List;

/**
 * (Answer)表服务接口
 *
 * @author makejava
 * @since 2020-03-18 23:28:05
 */
public interface AnswerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Answer queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Answer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    Answer insert(Answer answer);


    List<Answer> queryAll(Answer answer);
    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    Answer update(Answer answer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}