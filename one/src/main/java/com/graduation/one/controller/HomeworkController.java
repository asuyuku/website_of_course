package com.graduation.one.controller;

import com.graduation.one.base.AjaxResult;
import com.graduation.one.entity.AdminUser;
import com.graduation.one.entity.Homework;
import com.graduation.one.service.HomeworkService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @RequestMapping("/add")
    public ModelAndView addHomework() {
        return new ModelAndView("adminSystem/homework/add");
    }

    @RequestMapping("/addHomework")
    @ResponseBody
    public AjaxResult addHomework(Homework homework, HttpServletRequest request)
    {
        try{
            if(homework.getFile()!=null) {
                String fileName =  new Date().getTime() + homework.getFile().getOriginalFilename();
                File newFile = new File("I:\\website_of_homework\\one\\src\\main\\webapp" ,fileName);
                homework.getFile().transferTo(newFile);
                homework.setFileName(fileName);
            }
            AdminUser adminUser=(AdminUser)request.getSession().getAttribute("adminUser");
            if(ObjectUtils.isEmpty(adminUser))
            {
                return AjaxResult.errorInstance("登陆状态失效，请重新登陆！");
            }
            homework.setUserId(adminUser.getAdminId());
            homeworkService.addHomework(homework);
            return AjaxResult.successInstance("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.errorInstance("error");
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateHomework(@PathVariable int id,HttpServletRequest request)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/homework/update");
        try{
            AdminUser adminUser=(AdminUser)request.getSession().getAttribute("adminUser");
            Homework homework=homeworkService.queryOneHomework(id);
            modelAndView.addObject("user",adminUser);
            modelAndView.addObject("homework",homework);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/updateHomework")
    @ResponseBody
    public AjaxResult updateHomework(Homework homework)
    {
        try {
            if(homework.getFile()!=null) {
                String fileName =  new Date().getTime() + homework.getFile().getOriginalFilename();
                File newFile = new File("I:\\website_of_homework\\one\\src\\main\\webapp",fileName);
                homework.getFile().transferTo(newFile);
                homework.setFileName(fileName);
            }
            homeworkService.updateHomework(homework);
            return AjaxResult.successInstance("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.errorInstance("error");
    }

    @RequestMapping("/list")
    public ModelAndView homeworkList()
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/homework/list");
        try{
            List<Homework> homeworkList = homeworkService.queryHomeworkList();
            modelAndView.addObject("homeworkList",homeworkList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
