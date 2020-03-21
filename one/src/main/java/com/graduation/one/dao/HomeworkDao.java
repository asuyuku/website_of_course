package com.graduation.one.dao;

import com.graduation.one.entity.Homework;

import java.util.List;


public interface HomeworkDao {

    List<Homework> queryHomeworkList();

    Homework queryOneHomework(int id);

    void updateHomework(Homework homework);

    void addHomework(Homework homework);
}
