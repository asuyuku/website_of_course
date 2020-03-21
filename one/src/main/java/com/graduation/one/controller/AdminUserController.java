package com.graduation.one.controller;

import com.graduation.one.base.AjaxResult;
import com.graduation.one.base.JsonResult;
import com.graduation.one.entity.AdminUser;
import com.graduation.one.service.AdminUserService;
import com.graduation.one.utils.Algorithm;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * (AdminUser)表控制层
 *
 * @author makejava
 * @since 2019-12-31 14:31:42
 */
@Controller
@RequestMapping("adminUser")
public class AdminUserController {
    /**
     * 服务对象
     */
    @Resource
    private AdminUserService adminUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public JsonResult<AdminUser> selectOne(Integer id) {
        JsonResult<AdminUser> result = new JsonResult<>();
        AdminUser adminUser = adminUserService.queryById(id);
        return result.success("查询成功", adminUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("adminSystem/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginSubmit(@NotNull String account, String password, HttpServletRequest request) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return new ModelAndView("adminSystem/login", "message", "用户名或密码不能为空！");
        }
        AdminUser adminUser = adminUserService.login(account, password);
        if (adminUser == null) {
            return new ModelAndView("adminSystem/login", "message", "用户名或密码错误！");
        }
        if (adminUser.isDisabled()) {
            return new ModelAndView("adminSystem/login", "message", "此账户已被停用！");
        }
        request.getSession().setAttribute("adminUser", adminUser);
        return new ModelAndView("redirect:/adminUser/index");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("redirect:/adminUser/login");
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/adminUser/add");
        try {
            AdminUser adminUser=new AdminUser();
            adminUser.setType(1);
            List<AdminUser> teacherList=adminUserService.queryAll(adminUser );
            modelAndView.addObject("teacherList",teacherList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addSubmit(AdminUser adminUser) {
        if (StringUtils.isEmpty(adminUser.getUserName()) || adminUser.getUserName() == null) {
            return AjaxResult.errorInstance("管理员姓名不能为空");
        }
        if (StringUtils.isEmpty(adminUser.getAdminName()) || adminUser.getAdminName() == null) {
            return AjaxResult.errorInstance("管理员用户名不能为空");
        }

        if (adminUserService.isExisted(adminUser)) {
            return AjaxResult.errorInstance("该管理员已经存在");
        }

        adminUser.setPassword(adminUser.getPassword());

        adminUserService.insert(adminUser);
        return AjaxResult.successInstance("管理员添加成功");
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(Integer id) {
        adminUserService.deleteById(id);
        return AjaxResult.successInstance("删除成功");
    }

    @RequestMapping(value = "/resetPW", method = RequestMethod.GET)
    public ModelAndView resetPwPage(AdminUser adminUser) {
        adminUser = adminUserService.queryById(adminUser.getAdminId());
        ModelAndView modelAndView = new ModelAndView("adminSystem/resetPassword");
        modelAndView.addObject("adminUser", adminUser);
        return modelAndView;
    }

    @RequestMapping(value = "/resetPW.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult resetPassword(AdminUser adminUser) {
        adminUser.setPassword(Algorithm.mD5(adminUser.getPassword()));
        adminUserService.update(adminUser);
        return AjaxResult.successInstance("重置密码成功！");
    }

    @RequestMapping("/disable.do")
    @ResponseBody
    public AjaxResult disable(Integer adminUserId) {
        AdminUser adminUser = adminUserService.queryById(adminUserId);
        if (adminUser.isDisabled()) {
            adminUser.setDataState(3);
        } else {
            adminUser.setDataState(1);
        }
        adminUserService.update(adminUser);
        return AjaxResult.successInstance("更改状态成功");
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    public ModelAndView updatePasswordPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("adminSystem/updatePassword");
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
        modelAndView.addObject("adminUser", adminUser);
        return modelAndView;
    }

    @RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updatePasswordSubmit(String password, String newpassword, HttpServletRequest request) {
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
        if (!Algorithm.mD5(password).equals(adminUser.getPassword())) {
            return AjaxResult.errorInstance("旧密码错误！");
        }
        adminUser.setPassword(Algorithm.mD5(newpassword));
        adminUserService.update(adminUser);
        return AjaxResult.successInstance("修改密码成功");
    }

    @RequestMapping("/index")
    public ModelAndView index()
    {
        return new ModelAndView("adminSystem/index");
    }

    @RequestMapping("/list")
    public ModelAndView list(Integer offset,Integer limit)
    {
        ModelAndView modelAndView=new ModelAndView("adminSystem/adminUser/list");
        try{
            if(offset==null)
            {
                offset=0;
            }
            if(limit==null)
            {
                limit=10;
            }
            List<AdminUser> adminUserList=adminUserService.queryAllByLimit();
            modelAndView.addObject("adminUserList",adminUserList);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return modelAndView;
    }
}