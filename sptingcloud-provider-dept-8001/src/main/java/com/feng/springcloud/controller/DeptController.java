package com.feng.springcloud.controller;

import com.feng.springcloud.pojo.Dept;
import com.feng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
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

    //获取一些配置信息
    @Autowired
    private DiscoveryClient discoveryClient;

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

    //获取微服务信息
    @RequestMapping("/dept/discovery")
    public Object discovery()
    {
        //获取服务列表，也就是管理页面显示的
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>services:" + services);

        //得到一个具体的服务,根据spring-application-name设置的名字获取
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance : instances)
        {
            System.out.println("Host:" + instance.getHost());
            System.out.println("Port:" + instance.getPort());
            System.out.println("Uri:" + instance.getUri());
            System.out.println("ServiceId:" + instance.getServiceId());
        }

        return this.discoveryClient;
    }
}
