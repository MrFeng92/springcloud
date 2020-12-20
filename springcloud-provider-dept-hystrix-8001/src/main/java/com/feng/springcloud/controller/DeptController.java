package com.feng.springcloud.controller;

import com.feng.springcloud.pojo.Dept;
import com.feng.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept queryById(@PathVariable("id") Long id)
    {
        Dept dept = deptService.queryById(id);
        if (dept == null)
        {
            throw new RuntimeException("id => " + id + ",不存在该用户，或者无法找到");
        }
        return dept;
    }

    //备选方法
    public Dept hystrixGet(@PathVariable("id") Long id)
    {
        Dept dept = new Dept();
        dept.setDept_id(id);
        dept.setDept_name("id => " + id + "没有对应的信息，null--@Hystrix");
        dept.setDb_source("no this database in mysql");
        return dept;

    }
}
