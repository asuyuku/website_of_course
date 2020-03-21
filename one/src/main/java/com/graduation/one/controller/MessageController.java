package com.graduation.one.controller;

import com.graduation.one.base.AjaxResult;
import com.graduation.one.entity.AdminUser;
import com.graduation.one.entity.Message;
import com.graduation.one.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {
    @Resource
    private MessageService messageService;

    @RequestMapping("/message/list/{type}")
    public ModelAndView messageList(@PathVariable int type)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/message/messageList");
        try{
            List<Message> messageList=messageService.queryMessageByType(type);
            modelAndView.addObject("messageList",messageList);
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return modelAndView;
    }

    @RequestMapping("/addMessagePage/{type}")
    public ModelAndView addMessagePage(@PathVariable int type)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/message/addMessage");
        modelAndView.addObject("type",type);
        return modelAndView;
    }

    @RequestMapping(value = "/addMessage",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addMessage(Message message, HttpServletRequest request)
    {
        try {
            if(StringUtils.isEmpty(message.getTitle())) 
            {
                return AjaxResult.errorInstance("标题不能为空");
            }
            if(StringUtils.isEmpty(message.getContent()))
            {
                return AjaxResult.errorInstance("内容不能为空");
            }
            AdminUser adminUser=(AdminUser)request.getSession().getAttribute("adminUser");
            if(ObjectUtils.isEmpty(adminUser))
            {
                return AjaxResult.errorInstance("登陆状态失效，请重新登陆！");
            }
            messageService.addMessage(message);
            return AjaxResult.successInstance("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorInstance(e);
        }
    }

    @RequestMapping("/messageInfo/{id}")
    public ModelAndView messageInfo( @PathVariable int id)
    {
        ModelAndView modelAndView=new ModelAndView("/adminSystem/message/messageInfo");
        try{
            Message message=messageService.queryMessageById(id);
            modelAndView.addObject("message",message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/updateMessage")
    @ResponseBody
    public AjaxResult updateMessage(Message message)
    {
        try{
            if(StringUtils.isEmpty(message.getTitle()))
            {
                return AjaxResult.errorInstance("标题不能为空");
            }
            if(StringUtils.isEmpty(message.getContent()))
            {
                return AjaxResult.errorInstance("内容不能为空！");
            }
            messageService.updateMessageById(message);
            return AjaxResult.successInstance("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorInstance(e);
        }
    }

    @RequestMapping("/deleteMessage/{id}")
    @ResponseBody
    public AjaxResult deleteMessage(@PathVariable int id)
    {
        try{
            messageService.deleteMessageById(id);
            return AjaxResult.successInstance("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorInstance(e);
        }
    }
}
