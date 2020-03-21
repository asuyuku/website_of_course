package com.graduation.one.controller;

import com.graduation.one.entity.Applicant;
import com.graduation.one.service.ApplicantService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Applicant)表控制层
 *
 * @author makejava
 * @since 2019-12-31 14:29:31
 */
@RestController
@RequestMapping("applicant")
public class ApplicantController {
    /**
     * 服务对象
     */
    @Resource
    private ApplicantService applicantService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Applicant selectOne(Integer id) {
        return this.applicantService.queryById(id);
    }

}