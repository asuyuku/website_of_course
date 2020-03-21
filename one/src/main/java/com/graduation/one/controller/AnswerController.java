package com.graduation.one.controller;

import com.graduation.one.base.AjaxResult;
import com.graduation.one.entity.AdminUser;
import com.graduation.one.entity.Answer;
import com.graduation.one.entity.Homework;
import com.graduation.one.service.AnswerService;
import com.graduation.one.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * (Answer)表控制层
 *
 * @author makejava
 * @since 2020-03-18 23:28:06
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Resource
    private AnswerService answerService;
    @Autowired
    private HomeworkService homeworkService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Answer selectOne(Integer id) {
        return this.answerService.queryById(id);
    }


    @RequestMapping("/list/{homeworkId}")
    public ModelAndView list(@PathVariable int homeworkId)
    {
        ModelAndView modelAndView = new ModelAndView("adminSystem/answer/list");
        try {
            Answer answer=new Answer();
            answer.setHomeworkId(homeworkId);
            List<Answer> answerList=answerService.queryAll(answer);
            modelAndView.addObject("answerList",answerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/add/{homeworkId}")
    public ModelAndView add(@PathVariable int homeworkId)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/answer/add");
        try{
            Homework homework=homeworkService.queryOneHomework(homeworkId);
            modelAndView.addObject("homework",homework);
            modelAndView.addObject("homeworkId",homeworkId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/addAnswer")
    @ResponseBody
    public AjaxResult addAnswer(Answer answer, HttpServletRequest request)
    {
        try{
            if(answer.getFile()!=null) {
                String fileName =  new Date().getTime() + answer.getFile().getOriginalFilename();
                File newFile = new File("I:\\website_of_homework\\one\\src\\main\\webapp" ,fileName);
                answer.getFile().transferTo(newFile);
                answer.setFileName(fileName);
            }
            AdminUser adminUser=(AdminUser)request.getSession().getAttribute("adminUser");
            if(ObjectUtils.isEmpty(adminUser))
            {
                return AjaxResult.errorInstance("登陆状态失效，请重新登陆！");
            }
            answer.setUserId(adminUser.getAdminId());
            answerService.insert(answer);
            return AjaxResult.successInstance("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.errorInstance("error");
    }

    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable int id,HttpServletRequest request)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/answer/update");
        try {
            AdminUser adminUser=(AdminUser)request.getSession().getAttribute("adminUser");
            modelAndView.addObject("user",adminUser);
            Answer answer=answerService.queryById(id);
            modelAndView.addObject("answer",answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/updateAnswer")
    @ResponseBody
    public AjaxResult updateAnswer(Answer answer)
    {
        try {
            if(answer.getFile()!=null) {
                String fileName =  new Date().getTime() + answer.getFile().getOriginalFilename();
                File newFile = new File("I:\\website_of_homework\\one\\src\\main\\webapp" ,fileName);
                answer.getFile().transferTo(newFile);
                answer.setFileNameTwo(fileName);
            }
            answerService.update(answer);
            return AjaxResult.successInstance("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.errorInstance("error");
    }
}