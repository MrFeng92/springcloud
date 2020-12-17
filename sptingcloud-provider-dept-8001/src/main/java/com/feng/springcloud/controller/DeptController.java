package com.feng.springcloud.controller;

import com.feng.springcloud.pojo.Dept;
import com.feng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供Restful服务
 */
@RestController
public class DeptController
{
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id)
    {
        return deptService.queryById(id);
    }

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept)
    {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll()
    {
        return deptService.queryAll();
    }
}
