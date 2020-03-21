package com.graduation.one.service;

import com.graduation.one.entity.Homework;

import java.util.List;

public interface HomeworkService {
    List<Homework> queryHomeworkList();
    Homework queryOneHomework(int id);
    void addHomework(Homework homework);
    void updateHomework(Homework homework);
}
