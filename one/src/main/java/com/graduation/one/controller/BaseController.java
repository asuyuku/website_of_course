package com.graduation.one.controller;

import com.graduation.one.entity.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tongyw
 * @date 2020/1/2 14:32
 */
@Controller
public class BaseController {
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request)
    {
        AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUser");
        if(adminUser == null){
            return new ModelAndView("redirect:/adminUser/login");
        }
        return new ModelAndView("/index");
    }

    @RequestMapping("/welcome.do")
    public ModelAndView welcome()
    {
        return new ModelAndView("welcome");
    }

}
