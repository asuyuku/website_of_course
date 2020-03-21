package com.graduation.one.service.impl;

import com.graduation.one.dao.HomeworkDao;
import com.graduation.one.entity.Homework;
import com.graduation.one.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("homeworkService")
public class HomeworkServiceImpl implements HomeworkService {
    @Resource
    private HomeworkDao homeworkDao;
    @Override
    public List<Homework> queryHomeworkList() {
        return homeworkDao.queryHomeworkList();
    }

    @Override
    public Homework queryOneHomework(int id) {
        return homeworkDao.queryOneHomework(id);
    }

    @Override
    public void addHomework(Homework homework) {
        homeworkDao.addHomework(homework);
    }

    @Override
    public void updateHomework(Homework homework) {
        homeworkDao.updateHomework(homework);
    }
}
