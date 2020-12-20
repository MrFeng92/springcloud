package com.feng.springcloud.service;

import com.feng.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
    和 @Reference 是一样的
    value 是微服务的名字
*/
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
@Component
public interface DeptClientService
{
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @GetMapping("/dept/add")
    public boolean addDept(Dept dept);
}
